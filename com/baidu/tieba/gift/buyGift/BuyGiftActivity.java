package com.baidu.tieba.gift.buyGift;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.Selection;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.util.SparseIntArray;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.inputmethod.InputMethodManager;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.GridView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import androidx.viewpager.widget.ViewPager;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.listener.HttpMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.message.HttpResponsedMessage;
import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.adp.framework.message.SocketResponsedMessage;
import com.baidu.adp.framework.task.SocketMessageTask;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.widget.IndicatorView;
import com.baidu.tbadk.ActivityPendingTransitionFactory;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.BuyTBeanActivityConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.core.message.SendGiftSuccessMessage;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StringHelper;
import com.baidu.tbadk.core.view.BaseViewPager;
import com.baidu.tbadk.task.TbHttpMessageTask;
import com.baidu.tieba.R;
import com.baidu.tieba.gift.buyGift.GiftCommonList;
import com.baidu.ueg.encrypt.entity.EncryptAlgorithm;
import d.b.h0.r.s.a;
import java.util.ArrayList;
import java.util.List;
import tbclient.SendGiftAndroid.DataRes;
import tbclient.SendGiftAndroid.SendGiftAndroidResIdl;
/* loaded from: classes4.dex */
public class BuyGiftActivity extends BaseActivity<BuyGiftActivity> implements ViewPager.OnPageChangeListener {
    public static final int ERROR_GIFT_PRICE_CHANGED = 1990019;
    public static final int ERROR_NEED_PASSWORD = 1990027;
    public static final int ERROR_NOT_ENOUGH_TDOU = 1990018;
    public static final int ERROR_PASSWORD_INVALID = 1990028;
    public static final int ITEM_PER_PAGE = 8;
    public View empty_layout;
    public TextView gift_button;
    public EditText gift_count_input;
    public TextView gift_count_result;
    public View gift_list_layout;
    public View gift_lower_layout;
    public View gift_num_layout;
    public ListView gift_num_list;
    public FrameLayout gift_panel_lay;
    public View gift_progress_layout;
    public IndicatorView gift_tab_indicator;
    public LinearLayout gift_tab_layout;
    public BaseViewPager gift_viewpager;
    public GiftCommonList.GiftItem mCurrentItem;
    public int mCurrentPage;
    public int mFrom;
    public GiftCommonList mGiftCommonList;
    public d.b.i0.t0.a.b mGiftNumAdapter;
    public GiftPagerAdapter mGiftPagerAdapter;
    public InputMethodManager mInputMethodManager;
    public String mPassword;
    public String mPublicKey;
    public View mPwdContentView;
    public d.b.h0.r.s.a mPwdDialog;
    public EditText mPwdText;
    public long mReceiverId;
    public int mSelectedPage;
    public int mSelectedPosition;
    public TextView password_dialog_warning;
    public List<View> mViewPagerContent = new ArrayList();
    public SparseIntArray mPageInfos = new SparseIntArray();
    public boolean mHasYinji = false;
    public boolean mHasShowAnim = false;
    public SendGiftSuccessMessage.a mGiftInfo = new SendGiftSuccessMessage.a();
    public final HttpMessageListener mGetGiftsHttpListener = new g(CmdConfigHttp.GET_GIFT_LIST);
    public final d.b.b.c.g.c mGetGiftsSocketListener = new h(308001);
    public final d.b.b.c.g.a mSendGiftNetListener = new i(CmdConfigHttp.SEND_GIFT, 308007);
    public final CustomMessageListener mBuyTdouListener = new j(2001227);

    /* loaded from: classes4.dex */
    public class a implements View.OnClickListener {
        public a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            BuyGiftActivity.this.sendGift();
        }
    }

    /* loaded from: classes4.dex */
    public class b implements View.OnClickListener {
        public b() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            BuyGiftActivity.this.gift_num_layout.setVisibility(8);
        }
    }

    /* loaded from: classes4.dex */
    public class c implements a.e {
        public c() {
        }

        @Override // d.b.h0.r.s.a.e
        public void onClick(d.b.h0.r.s.a aVar) {
            BuyGiftActivity.this.mPassword = "";
            BuyGiftActivity.this.mPwdText.clearFocus();
            BuyGiftActivity buyGiftActivity = BuyGiftActivity.this;
            buyGiftActivity.HidenSoftKeyPad(buyGiftActivity.mInputMethodManager, BuyGiftActivity.this.mPwdText);
            BuyGiftActivity.this.mPwdDialog.dismiss();
        }
    }

    /* loaded from: classes4.dex */
    public class d implements a.e {
        public d() {
        }

        @Override // d.b.h0.r.s.a.e
        public void onClick(d.b.h0.r.s.a aVar) {
            BuyGiftActivity.this.showWarningOrNot(false);
            BuyGiftActivity buyGiftActivity = BuyGiftActivity.this;
            buyGiftActivity.mPassword = buyGiftActivity.mPwdText.getText().toString();
            if (StringUtils.isValidPassWord(BuyGiftActivity.this.mPassword)) {
                if (!StringUtils.isNull(BuyGiftActivity.this.mPublicKey)) {
                    try {
                        d.b.n0.a.a a2 = d.b.n0.a.b.a(new d.b.n0.a.d.a(EncryptAlgorithm.RSA, BuyGiftActivity.this.mPublicKey));
                        BuyGiftActivity.this.mPassword = a2.a(BuyGiftActivity.this.mPassword);
                    } catch (Exception e2) {
                        BuyGiftActivity.this.mPassword = "";
                        e2.printStackTrace();
                    }
                }
                BuyGiftActivity.this.sendGift();
                BuyGiftActivity.this.mPwdText.setText("");
                return;
            }
            BuyGiftActivity.this.showWarningOrNot(true);
        }
    }

    /* loaded from: classes4.dex */
    public class e implements Runnable {
        public e() {
        }

        @Override // java.lang.Runnable
        public void run() {
            BuyGiftActivity.this.mPwdDialog.show();
        }
    }

    /* loaded from: classes4.dex */
    public class f implements Runnable {
        public f() {
        }

        @Override // java.lang.Runnable
        public void run() {
            BuyGiftActivity buyGiftActivity = BuyGiftActivity.this;
            buyGiftActivity.ShowSoftKeyPad((InputMethodManager) buyGiftActivity.getSystemService("input_method"), BuyGiftActivity.this.mPwdText);
        }
    }

    /* loaded from: classes4.dex */
    public class g extends HttpMessageListener {
        public g(int i) {
            super(i);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage instanceof GetGiftCommonListHttpResponseMessage) {
                GetGiftCommonListHttpResponseMessage getGiftCommonListHttpResponseMessage = (GetGiftCommonListHttpResponseMessage) httpResponsedMessage;
                BuyGiftActivity.this.mGiftCommonList = getGiftCommonListHttpResponseMessage.getGiftInfo();
                BuyGiftActivity.this.handleGetGiftsResponse(getGiftCommonListHttpResponseMessage.getError(), getGiftCommonListHttpResponseMessage.getErrorString());
            }
        }
    }

    /* loaded from: classes4.dex */
    public class h extends d.b.b.c.g.c {
        public h(int i) {
            super(i);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(SocketResponsedMessage socketResponsedMessage) {
            if (socketResponsedMessage instanceof GetGiftCommonListSocketResponseMessage) {
                GetGiftCommonListSocketResponseMessage getGiftCommonListSocketResponseMessage = (GetGiftCommonListSocketResponseMessage) socketResponsedMessage;
                BuyGiftActivity.this.mGiftCommonList = getGiftCommonListSocketResponseMessage.getGiftInfo();
                BuyGiftActivity.this.handleGetGiftsResponse(getGiftCommonListSocketResponseMessage.getError(), getGiftCommonListSocketResponseMessage.getErrorString());
            }
        }
    }

    /* loaded from: classes4.dex */
    public class i extends d.b.b.c.g.a {
        public i(int i, int i2) {
            super(i, i2);
        }

        @Override // d.b.b.c.g.a
        public void onMessage(ResponsedMessage<?> responsedMessage) {
            if (responsedMessage instanceof SendGiftSocketResponseMessage) {
                BuyGiftActivity.this.gift_button.setEnabled(true);
                SendGiftSocketResponseMessage sendGiftSocketResponseMessage = (SendGiftSocketResponseMessage) responsedMessage;
                BuyGiftActivity.this.handleSendGiftResponse(sendGiftSocketResponseMessage.getError(), sendGiftSocketResponseMessage.getErrorString(), sendGiftSocketResponseMessage.getResponseData());
            } else if (responsedMessage instanceof SendGiftHttpResponseMessage) {
                BuyGiftActivity.this.gift_button.setEnabled(true);
                SendGiftHttpResponseMessage sendGiftHttpResponseMessage = (SendGiftHttpResponseMessage) responsedMessage;
                BuyGiftActivity.this.handleSendGiftResponse(sendGiftHttpResponseMessage.getError(), sendGiftHttpResponseMessage.getErrorString(), sendGiftHttpResponseMessage.getResponseData());
            }
        }
    }

    /* loaded from: classes4.dex */
    public class j extends CustomMessageListener {
        public j(int i) {
            super(i);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            BuyGiftActivity.this.mHasYinji = true;
            BuyGiftActivity.this.sendGift();
        }
    }

    /* loaded from: classes4.dex */
    public class k implements Animation.AnimationListener {
        public k() {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
            BuyGiftActivity.this.gift_list_layout.setVisibility(0);
            BuyGiftActivity.this.getGiftList();
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationRepeat(Animation animation) {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationStart(Animation animation) {
        }
    }

    /* loaded from: classes4.dex */
    public class l implements Animation.AnimationListener {
        public l() {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
            BuyGiftActivity.this.finish();
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationRepeat(Animation animation) {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationStart(Animation animation) {
        }
    }

    /* loaded from: classes4.dex */
    public class m implements View.OnClickListener {
        public m() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (BuyGiftActivity.this.gift_num_layout.getVisibility() == 0) {
                BuyGiftActivity.this.gift_num_layout.setVisibility(8);
            } else {
                BuyGiftActivity.this.closeActivity();
            }
        }
    }

    /* loaded from: classes4.dex */
    public class n implements View.OnClickListener {

        /* loaded from: classes4.dex */
        public class a implements Runnable {
            public a() {
            }

            @Override // java.lang.Runnable
            public void run() {
                BuyGiftActivity.this.changeEditTextFocusState(false);
                BuyGiftActivity.this.gift_num_layout.setVisibility(0);
            }
        }

        public n() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            BuyGiftActivity buyGiftActivity = BuyGiftActivity.this;
            buyGiftActivity.HidenSoftKeyPad(buyGiftActivity.mInputMethodManager, BuyGiftActivity.this.gift_count_input);
            BuyGiftActivity.this.mHandler.postDelayed(new a(), 200L);
        }
    }

    /* loaded from: classes4.dex */
    public class o implements View.OnFocusChangeListener {
        public o() {
        }

        @Override // android.view.View.OnFocusChangeListener
        public void onFocusChange(View view, boolean z) {
            if (z) {
                BuyGiftActivity buyGiftActivity = BuyGiftActivity.this;
                buyGiftActivity.ShowSoftKeyPad(buyGiftActivity.mInputMethodManager, BuyGiftActivity.this.gift_count_input);
                return;
            }
            BuyGiftActivity buyGiftActivity2 = BuyGiftActivity.this;
            buyGiftActivity2.HidenSoftKeyPad(buyGiftActivity2.mInputMethodManager, BuyGiftActivity.this.gift_count_input);
        }
    }

    /* loaded from: classes4.dex */
    public class p implements AdapterView.OnItemClickListener {
        public p() {
        }

        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
            BuyGiftActivity buyGiftActivity = BuyGiftActivity.this;
            buyGiftActivity.mSelectedPage = buyGiftActivity.mCurrentPage;
            BuyGiftActivity.this.mSelectedPosition = i;
            d.b.i0.t0.a.a aVar = (d.b.i0.t0.a.a) adapterView.getAdapter();
            if (aVar != null) {
                GiftCommonList.GiftItem item = aVar.getItem(i);
                if (item != null) {
                    BuyGiftActivity.this.mCurrentItem = item;
                }
                aVar.d(i);
                aVar.notifyDataSetChanged();
            }
            BuyGiftActivity.this.countTotalPrice(true);
        }

        public /* synthetic */ p(BuyGiftActivity buyGiftActivity, g gVar) {
            this();
        }
    }

    /* loaded from: classes4.dex */
    public class q implements AdapterView.OnItemClickListener {
        public q() {
        }

        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
            if (BuyGiftActivity.this.mGiftCommonList == null || BuyGiftActivity.this.mGiftCommonList.getGiftInfo() == null) {
                return;
            }
            List<GiftCommonList.NumInfo> numInfo = BuyGiftActivity.this.mGiftCommonList.getGiftInfo().getNumInfo();
            if (i == numInfo.size()) {
                BuyGiftActivity.this.changeEditTextFocusState(true);
                Selection.selectAll(BuyGiftActivity.this.gift_count_input.getText());
            } else {
                BuyGiftActivity.this.gift_count_input.setCursorVisible(true);
                BuyGiftActivity.this.gift_count_input.setFocusable(true);
                GiftCommonList.NumInfo numInfo2 = numInfo.get(i);
                if (numInfo2 != null) {
                    EditText editText = BuyGiftActivity.this.gift_count_input;
                    editText.setText("" + numInfo2.getNum());
                }
            }
            BuyGiftActivity.this.gift_num_layout.setVisibility(8);
            BuyGiftActivity.this.countTotalPrice(true);
        }

        public /* synthetic */ q(BuyGiftActivity buyGiftActivity, g gVar) {
            this();
        }
    }

    /* loaded from: classes4.dex */
    public class r implements TextWatcher {
        public r() {
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            int d2 = d.b.b.e.m.b.d(editable.toString(), 0);
            if (editable.toString().length() == String.valueOf(d2).length()) {
                BuyGiftActivity.this.countTotalPrice(true);
                return;
            }
            int i = d2 >= 0 ? d2 : 0;
            EditText editText = BuyGiftActivity.this.gift_count_input;
            editText.setText("" + i);
            BuyGiftActivity.this.gift_count_input.setSelection(String.valueOf(i).length());
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }

        public /* synthetic */ r(BuyGiftActivity buyGiftActivity, g gVar) {
            this();
        }
    }

    /* loaded from: classes4.dex */
    public class s implements View.OnClickListener {

        /* renamed from: e  reason: collision with root package name */
        public int f16864e;

        public s(int i) {
            this.f16864e = i;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            int min = Math.min(this.f16864e, BuyGiftActivity.this.mPageInfos.size());
            int i = 0;
            for (int i2 = 0; i2 < min; i2++) {
                i += BuyGiftActivity.this.mPageInfos.get(i2);
            }
            BuyGiftActivity.this.mCurrentPage = i;
            BuyGiftActivity.this.gift_viewpager.setCurrentItem(BuyGiftActivity.this.mCurrentPage);
            BuyGiftActivity.this.updateIndicatorAndTabs();
        }
    }

    @SuppressLint({"ResourceAsColor"})
    private void addTabs(List<GiftCommonList.TypeInfo> list) {
        if (list == null || list.size() <= 0) {
            return;
        }
        this.gift_tab_layout.removeAllViews();
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(0, -1);
        layoutParams.weight = 1.0f;
        filterGiftTypes(list);
        int size = list.size();
        for (int i2 = 0; i2 < size; i2++) {
            GiftCommonList.TypeInfo typeInfo = list.get(i2);
            if (!TextUtils.isEmpty(typeInfo.getTypeName()) && typeInfo.getGiftItems().size() > 0) {
                TextView textView = (TextView) LayoutInflater.from(getPageContext().getPageActivity()).inflate(R.layout.gift_tab_item, (ViewGroup) null);
                SkinManager.setBackgroundColor(textView, R.color.CAM_X0205);
                textView.setText(typeInfo.getTypeName());
                textView.setOnClickListener(new s(i2));
                textView.setSingleLine();
                textView.setEllipsize(TextUtils.TruncateAt.END);
                textView.setPadding(8, 0, 8, 0);
                this.gift_tab_layout.addView(textView, layoutParams);
            }
        }
        handleTabUi(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void changeEditTextFocusState(boolean z) {
        this.gift_count_input.setCursorVisible(z);
        this.gift_count_input.setFocusable(z);
        this.gift_count_input.setFocusableInTouchMode(z);
        if (z) {
            this.gift_count_input.requestFocus();
        } else {
            this.gift_count_input.clearFocus();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int countTotalPrice(boolean z) {
        int d2 = d.b.b.e.m.b.d(this.gift_count_input.getText().toString(), 1);
        GiftCommonList.GiftItem giftItem = this.mCurrentItem;
        int price = ((giftItem == null || giftItem.getPrice() <= 0) ? 1 : this.mCurrentItem.getPrice()) * d2;
        if (z) {
            this.gift_count_result.setText(String.format(getPageContext().getString(R.string.tdou_count_format), StringHelper.numFormat(price)));
            if (price <= 0) {
                SkinManager.setBackgroundResource(this.gift_button, R.drawable.btn_gift_give_d);
                this.gift_button.setEnabled(false);
            } else {
                SkinManager.setBackgroundResource(this.gift_button, R.drawable.btn_gift_give_normal);
                this.gift_button.setEnabled(true);
            }
            return price;
        }
        return price;
    }

    private List<GiftCommonList.GiftItem> filterGiftItems(List<GiftCommonList.GiftItem> list) {
        ArrayList arrayList = new ArrayList();
        if (list != null && list.size() != 0) {
            for (GiftCommonList.GiftItem giftItem : list) {
                if (giftItem.getPrice() > 0 && giftItem.getGiftId() > 0) {
                    arrayList.add(giftItem);
                }
            }
        }
        return arrayList;
    }

    private void filterGiftTypes(List<GiftCommonList.TypeInfo> list) {
        if (list == null || list.size() <= 0) {
            return;
        }
        ArrayList arrayList = new ArrayList();
        for (GiftCommonList.TypeInfo typeInfo : list) {
            if (TextUtils.isEmpty(typeInfo.getTypeName()) || typeInfo.getGiftItems().size() <= 0) {
                arrayList.add(typeInfo);
            }
        }
        list.removeAll(arrayList);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void getGiftList() {
        this.gift_progress_layout.setVisibility(0);
        this.gift_lower_layout.setVisibility(8);
        this.gift_num_layout.setVisibility(8);
        changeEditTextFocusState(false);
        HidenSoftKeyPad((InputMethodManager) getSystemService("input_method"), this.gift_count_input);
        sendMessage(new GetGiftCommonListRequestMessage());
    }

    private GridView getPageView(List<GiftCommonList.GiftItem> list, int i2) {
        d.b.i0.t0.a.a aVar = new d.b.i0.t0.a.a(getPageContext().getPageActivity());
        aVar.c(list);
        aVar.d(i2);
        GridView gridView = new GridView(getPageContext().getPageActivity());
        gridView.setVerticalScrollBarEnabled(false);
        gridView.setNumColumns(4);
        gridView.setVerticalSpacing(8);
        gridView.setHorizontalSpacing(8);
        gridView.setSelector(R.color.common_color_10022);
        gridView.setAdapter((ListAdapter) aVar);
        gridView.setPadding(4, 0, 4, 0);
        gridView.setOnItemClickListener(new p(this, null));
        return gridView;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void handleGetGiftsResponse(int i2, String str) {
        GiftCommonList giftCommonList;
        if (i2 == 0 && (giftCommonList = this.mGiftCommonList) != null && giftCommonList.getGiftInfo() != null && this.mGiftCommonList.getGiftInfo().getTypeInfo().size() > 0) {
            this.gift_button.setEnabled(true);
            this.gift_progress_layout.setVisibility(8);
            this.gift_lower_layout.setVisibility(0);
            updateViews();
            return;
        }
        if (TextUtils.isEmpty(str)) {
            showToast(R.string.neterror);
        } else {
            showToast(str);
        }
        closeActivity();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void handleSendGiftResponse(int i2, String str, SendGiftAndroidResIdl sendGiftAndroidResIdl) {
        DataRes dataRes;
        String str2;
        DataRes dataRes2;
        Integer num;
        d.b.h0.r.s.a aVar = this.mPwdDialog;
        if (aVar != null && aVar.isShowing()) {
            this.mPwdDialog.setYesBtnClickable(true);
            this.mPwdDialog.setNoBtnClickable(true);
        }
        this.gift_progress_layout.setVisibility(8);
        this.mPassword = "";
        if (i2 == 1990018 && !this.mHasYinji) {
            int countTotalPrice = countTotalPrice(false);
            int intValue = (sendGiftAndroidResIdl == null || (dataRes2 = sendGiftAndroidResIdl.data) == null || (num = dataRes2.money) == null) ? 0 : countTotalPrice - num.intValue();
            if (intValue > 0) {
                showToast(String.format(getPageContext().getString(R.string.not_enough_tdou_format), Integer.valueOf(intValue)));
            }
            sendMessage(new CustomMessage(2002001, new BuyTBeanActivityConfig(getPageContext().getPageActivity(), countTotalPrice)));
            InputMethodManager inputMethodManager = this.mInputMethodManager;
            if (inputMethodManager != null) {
                HidenSoftKeyPad(inputMethodManager, this.gift_count_input);
            }
            d.b.h0.r.s.a aVar2 = this.mPwdDialog;
            if (aVar2 == null || !aVar2.isShowing()) {
                return;
            }
            this.mPwdDialog.dismiss();
        } else if (i2 == 1990028) {
            showWarningOrNot(true);
        } else if (i2 == 1990019) {
            showToastFromServer(str, 0);
            getGiftList();
        } else if (i2 != 1990027) {
            if (i2 != 0) {
                showToastFromServer(str, R.string.neterror);
                return;
            }
            SendGiftSuccessMessage sendGiftSuccessMessage = new SendGiftSuccessMessage(2001232, Long.valueOf(this.mReceiverId));
            sendGiftSuccessMessage.setGiftInfo(this.mGiftInfo);
            MessageManager.getInstance().dispatchResponsedMessageToUI(sendGiftSuccessMessage);
            showToastFromServer(str, R.string.send_gift_succeed);
            closeActivity();
        } else {
            if (sendGiftAndroidResIdl != null && (dataRes = sendGiftAndroidResIdl.data) != null && (str2 = dataRes.public_key) != null) {
                this.mPublicKey = str2;
            }
            this.mHandler.post(new e());
            this.mPwdText.setText("");
            showWarningOrNot(false);
            this.mPwdText.requestFocus();
            this.mHandler.post(new f());
        }
    }

    @SuppressLint({"ResourceAsColor"})
    private void handleTabUi(int i2) {
        int childCount = this.gift_tab_layout.getChildCount();
        if (i2 < 0 || i2 >= childCount) {
            return;
        }
        for (int i3 = 0; i3 < childCount; i3++) {
            TextView textView = (TextView) this.gift_tab_layout.getChildAt(i3);
            if (i3 != i2) {
                SkinManager.setViewTextColor(textView, R.color.gift_tab_textcolor_normal, 1);
            } else {
                SkinManager.setViewTextColor(textView, R.color.gift_tab_textcolor_selected, 1);
            }
        }
    }

    private void hideAnimation() {
        this.empty_layout.setBackgroundColor(SkinManager.getColor(R.color.common_color_10175));
        AlphaAnimation alphaAnimation = new AlphaAnimation(0.9f, 0.0f);
        alphaAnimation.setDuration(300L);
        alphaAnimation.setFillAfter(true);
        this.empty_layout.startAnimation(alphaAnimation);
        Animation loadAnimation = AnimationUtils.loadAnimation(getPageContext().getPageActivity(), R.anim.bottom_fold_down);
        loadAnimation.setDuration(300L);
        loadAnimation.setFillAfter(true);
        loadAnimation.setAnimationListener(new l());
        this.gift_list_layout.startAnimation(loadAnimation);
    }

    private void inflateGiftList(List<GiftCommonList.TypeInfo> list) {
        List<GiftCommonList.GiftItem> subList;
        if (list == null) {
            return;
        }
        this.mPageInfos.clear();
        this.mViewPagerContent.clear();
        this.gift_viewpager.setAdapter(null);
        for (int i2 = 0; i2 < list.size(); i2++) {
            List<GiftCommonList.GiftItem> filterGiftItems = filterGiftItems(list.get(i2).getGiftItems());
            int size = filterGiftItems.size();
            if (size > 0) {
                if (this.mCurrentItem == null) {
                    this.mCurrentItem = filterGiftItems.get(0);
                    countTotalPrice(true);
                }
                int ceil = (int) Math.ceil(size / 8.0d);
                this.mPageInfos.append(i2, ceil);
                for (int i3 = 0; i3 < ceil; i3++) {
                    if (i3 == ceil - 1) {
                        int i4 = i3 * 8;
                        int i5 = size - 1;
                        if (i4 == i5) {
                            subList = new ArrayList<>();
                            subList.add(filterGiftItems.get(i5));
                        } else {
                            subList = filterGiftItems.subList(i4, size);
                        }
                    } else {
                        subList = filterGiftItems.subList(i3 * 8, (i3 + 1) * 8);
                    }
                    if (i2 == 0 && i3 == 0) {
                        this.mViewPagerContent.add(getPageView(subList, this.mSelectedPage));
                    } else {
                        this.mViewPagerContent.add(getPageView(subList, -1));
                    }
                }
            }
        }
        GiftPagerAdapter giftPagerAdapter = new GiftPagerAdapter(this.mViewPagerContent);
        this.mGiftPagerAdapter = giftPagerAdapter;
        this.gift_viewpager.setAdapter(giftPagerAdapter);
        updateIndicatorAndTabs();
    }

    private void inflateNumList(List<GiftCommonList.NumInfo> list) {
        ArrayList arrayList = new ArrayList();
        if (list != null && list.size() > 0) {
            for (GiftCommonList.NumInfo numInfo : list) {
                if (numInfo.getNum() <= 0) {
                    arrayList.add(numInfo);
                }
            }
            list.removeAll(arrayList);
        }
        d.b.i0.t0.a.b bVar = new d.b.i0.t0.a.b(getPageContext().getPageActivity());
        this.mGiftNumAdapter = bVar;
        this.gift_num_list.setAdapter((ListAdapter) bVar);
        this.mGiftNumAdapter.b(list);
    }

    private void initData() {
        if (getIntent() != null) {
            this.mReceiverId = getIntent().getLongExtra("gift_receiver_id", 0L);
        }
        registerTask();
        registerListener();
    }

    private void initViews() {
        this.gift_panel_lay = (FrameLayout) findViewById(R.id.gift_panel_lay);
        View findViewById = findViewById(R.id.empty_layout);
        this.empty_layout = findViewById;
        findViewById.setOnClickListener(new m());
        this.gift_list_layout = findViewById(R.id.gift_list_layout);
        this.mInputMethodManager = (InputMethodManager) getSystemService("input_method");
        EditText editText = (EditText) findViewById(R.id.gift_count_input);
        this.gift_count_input = editText;
        editText.setSelection(1);
        changeEditTextFocusState(false);
        this.gift_count_input.addTextChangedListener(new r(this, null));
        this.gift_count_input.setOnClickListener(new n());
        this.gift_count_input.setOnFocusChangeListener(new o());
        this.gift_count_result = (TextView) findViewById(R.id.gift_count_result);
        TextView textView = (TextView) findViewById(R.id.gift_button);
        this.gift_button = textView;
        textView.setEnabled(false);
        this.gift_button.setOnClickListener(new a());
        this.gift_lower_layout = findViewById(R.id.gift_lower_layout);
        BaseViewPager baseViewPager = (BaseViewPager) findViewById(R.id.gift_viewpager);
        this.gift_viewpager = baseViewPager;
        baseViewPager.setOnPageChangeListener(this);
        this.gift_tab_indicator = (IndicatorView) findViewById(R.id.gift_tab_indicator);
        this.gift_tab_layout = (LinearLayout) findViewById(R.id.gift_tab_layout);
        this.gift_progress_layout = findViewById(R.id.gift_progress_layout);
        View findViewById2 = findViewById(R.id.gift_num_layout);
        this.gift_num_layout = findViewById2;
        findViewById2.setOnClickListener(new b());
        ListView listView = (ListView) findViewById(R.id.gift_num_list);
        this.gift_num_list = listView;
        listView.setOnItemClickListener(new q(this, null));
        this.mPwdDialog = new d.b.h0.r.s.a(getActivity());
        View inflate = LayoutInflater.from(getActivity()).inflate(R.layout.dialog_tdou_pay_pwd, (ViewGroup) null);
        this.mPwdContentView = inflate;
        this.mPwdText = (EditText) inflate.findViewById(R.id.password_dialog_input);
        this.password_dialog_warning = (TextView) this.mPwdContentView.findViewById(R.id.password_dialog_warning);
        this.mPwdDialog.setContentView(this.mPwdContentView);
        this.mPwdDialog.setCanceledOnTouchOutside(false);
        this.mPwdDialog.setNegativeButton(getPageContext().getString(R.string.cancel), new c());
        this.mPwdDialog.setPositiveButton(getPageContext().getString(R.string.confirm), new d());
        this.mPwdDialog.create(getPageContext());
    }

    private void registerListener() {
        registerListener(this.mGetGiftsHttpListener);
        registerListener(this.mGetGiftsSocketListener);
        registerListener(this.mSendGiftNetListener);
        registerListener(this.mBuyTdouListener);
    }

    private void registerTask() {
        MessageManager messageManager = MessageManager.getInstance();
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(CmdConfigHttp.GET_GIFT_LIST, TbConfig.SERVER_ADDRESS + TbConfig.GIFT_COMMONLIST + "?cmd=308001");
        tbHttpMessageTask.setResponsedClass(GetGiftCommonListHttpResponseMessage.class);
        messageManager.registerTask(tbHttpMessageTask);
        d.b.h0.v0.b bVar = new d.b.h0.v0.b(308001);
        bVar.setResponsedClass(GetGiftCommonListSocketResponseMessage.class);
        bVar.g(true);
        bVar.h(false);
        bVar.f(SocketMessageTask.DupLicateMode.NONE);
        messageManager.registerTask(bVar);
        TbHttpMessageTask tbHttpMessageTask2 = new TbHttpMessageTask(CmdConfigHttp.SEND_GIFT, TbConfig.SERVER_ADDRESS + TbConfig.SEND_GIFT + "?cmd=308007");
        tbHttpMessageTask2.setResponsedClass(SendGiftHttpResponseMessage.class);
        messageManager.registerTask(tbHttpMessageTask2);
        d.b.h0.v0.b bVar2 = new d.b.h0.v0.b(308007);
        bVar2.setResponsedClass(SendGiftSocketResponseMessage.class);
        bVar2.g(true);
        bVar2.h(false);
        bVar2.f(SocketMessageTask.DupLicateMode.NONE);
        messageManager.registerTask(bVar2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void sendGift() {
        if (this.mCurrentItem == null || this.mReceiverId <= 0) {
            return;
        }
        d.b.h0.r.s.a aVar = this.mPwdDialog;
        if (aVar != null && aVar.isShowing()) {
            this.mPwdDialog.setYesBtnClickable(false);
            this.mPwdDialog.setNoBtnClickable(false);
        }
        this.gift_button.setEnabled(false);
        this.gift_progress_layout.setVisibility(0);
        RequestSendGiftNetMessage requestSendGiftNetMessage = new RequestSendGiftNetMessage();
        int d2 = d.b.b.e.m.b.d(String.valueOf(this.gift_count_input.getText()), 1);
        requestSendGiftNetMessage.setParams(this.mReceiverId, this.mCurrentItem.getGiftId(), this.mCurrentItem.getPrice(), d2, readFromVal(), this.mPassword);
        this.mGiftInfo.a(d2);
        this.mGiftInfo.c(this.mCurrentItem.getName());
        this.mGiftInfo.e(this.mCurrentItem.getThumbnailUrl());
        this.mGiftInfo.b(this.mCurrentItem.getGiftId());
        this.mGiftInfo.d(TbadkCoreApplication.getCurrentAccountName());
        sendMessage(requestSendGiftNetMessage);
    }

    private void showAnimation() {
        this.empty_layout.setBackgroundColor(SkinManager.getColor(R.color.common_color_10175));
        AlphaAnimation alphaAnimation = new AlphaAnimation(0.0f, 0.9f);
        alphaAnimation.setDuration(300L);
        this.empty_layout.startAnimation(alphaAnimation);
        Animation loadAnimation = AnimationUtils.loadAnimation(getPageContext().getPageActivity(), R.anim.bottom_fold_up);
        loadAnimation.setDuration(300L);
        loadAnimation.setFillAfter(true);
        loadAnimation.setAnimationListener(new k());
        this.gift_list_layout.startAnimation(loadAnimation);
        this.mHasShowAnim = true;
    }

    private void showToastFromServer(String str, int i2) {
        if (!TextUtils.isEmpty(str)) {
            showToast(str);
        } else if (i2 > 0) {
            showToast(i2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showWarningOrNot(boolean z) {
        if (z) {
            this.password_dialog_warning.setVisibility(0);
        } else {
            this.password_dialog_warning.setVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateIndicatorAndTabs() {
        int i2 = 0;
        for (int i3 = 0; i3 < this.mPageInfos.size(); i3++) {
            for (int i4 = 0; i4 < this.mPageInfos.get(i3); i4++) {
                if (i2 + i4 == this.mCurrentPage) {
                    if (this.mPageInfos.get(i3) <= 1) {
                        this.gift_tab_indicator.setVisibility(4);
                    } else {
                        this.gift_tab_indicator.setVisibility(0);
                    }
                    this.gift_tab_indicator.setCount(this.mPageInfos.get(i3));
                    this.gift_tab_indicator.setPosition(i4);
                    handleTabUi(i3);
                    return;
                }
            }
            i2 += this.mPageInfos.get(i3);
        }
    }

    private void updateViews() {
        GiftCommonList giftCommonList = this.mGiftCommonList;
        if (giftCommonList == null || giftCommonList.getGiftInfo() == null) {
            return;
        }
        List<GiftCommonList.TypeInfo> typeInfo = this.mGiftCommonList.getGiftInfo().getTypeInfo();
        addTabs(typeInfo);
        inflateGiftList(typeInfo);
        inflateNumList(this.mGiftCommonList.getGiftInfo().getNumInfo());
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void closeActivity() {
        hideAnimation();
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void closeAnimation() {
        ActivityPendingTransitionFactory.closeAnimation(getPageContext(), 0);
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void enterExitAnimation() {
        ActivityPendingTransitionFactory.enterExitAnimation(getPageContext(), 0);
    }

    @Override // android.app.Activity
    public void onBackPressed() {
        closeActivity();
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i2) {
        super.onChangeSkinType(i2);
        boolean z = TbadkCoreApplication.getInst().getSkinType() == 1;
        getLayoutMode().k(z);
        getLayoutMode().j(this.gift_list_layout);
        d.b.i0.t0.a.b bVar = this.mGiftNumAdapter;
        if (bVar != null) {
            bVar.notifyDataSetChanged();
        }
        if (z) {
            this.gift_tab_indicator.setSelector(getResources().getDrawable(R.drawable.icon_pagecontrol_on_1));
            this.gift_tab_indicator.setDrawable(getResources().getDrawable(R.drawable.icon_pagecontrol_off_1));
            return;
        }
        this.gift_tab_indicator.setSelector(getResources().getDrawable(R.drawable.icon_pagecontrol_on));
        this.gift_tab_indicator.setDrawable(getResources().getDrawable(R.drawable.icon_pagecontrol_off));
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        requestWindowFeature(1);
        super.onCreate(bundle);
        setSwipeBackEnabled(false);
        setActivityBgTransparent();
        setContentView(R.layout.activity_buy_gift);
        initViews();
        initData();
        this.mFrom = getIntent().getIntExtra("from", 1);
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i2, KeyEvent keyEvent) {
        if (i2 == 4) {
            d.b.h0.r.s.a aVar = this.mPwdDialog;
            if (aVar != null && aVar.isShowing()) {
                this.mPwdText.clearFocus();
                this.mPwdDialog.dismiss();
                return true;
            } else if (this.gift_num_layout.getVisibility() == 0) {
                this.gift_num_layout.setVisibility(8);
                return true;
            }
        }
        return super.onKeyDown(i2, keyEvent);
    }

    @Override // android.app.Activity
    public void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        this.mFrom = intent.getIntExtra("from", 1);
    }

    @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
    public void onPageScrollStateChanged(int i2) {
    }

    @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
    public void onPageScrolled(int i2, float f2, int i3) {
    }

    @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
    public void onPageSelected(int i2) {
        this.mCurrentPage = i2;
        updateIndicatorAndTabs();
        if (i2 < 0 || i2 >= this.mViewPagerContent.size()) {
            return;
        }
        GridView gridView = (GridView) this.mViewPagerContent.get(i2);
        if (gridView.getAdapter() != null) {
            d.b.i0.t0.a.a aVar = (d.b.i0.t0.a.a) gridView.getAdapter();
            if (aVar.b() >= 0 && i2 != this.mSelectedPage) {
                aVar.d(-1);
                aVar.notifyDataSetChanged();
            }
            if (aVar.b() >= 0 || i2 != this.mSelectedPage) {
                return;
            }
            aVar.d(this.mSelectedPosition);
            aVar.notifyDataSetChanged();
        }
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        if (!z || this.mHasShowAnim) {
            return;
        }
        showAnimation();
    }

    public int readFromVal() {
        int i2 = this.mFrom;
        int i3 = 2;
        if (i2 != 2) {
            i3 = 3;
            if (i2 != 3) {
                return 1;
            }
        }
        return i3;
    }
}
