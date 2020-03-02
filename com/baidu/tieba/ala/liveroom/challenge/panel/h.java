package com.baidu.tieba.ala.liveroom.challenge.panel;

import android.content.Context;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.live.adp.lib.util.BdNetTypeUtil;
import com.baidu.live.adp.lib.util.BdUtilHelper;
import com.baidu.live.adp.widget.listview.BdListView;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.live.tbadk.core.util.ListUtils;
import com.baidu.live.tbadk.widget.CommonEmptyView;
import com.baidu.live.u.a;
import java.util.List;
/* loaded from: classes3.dex */
public class h extends e {
    public a eVK;
    private EditText eVP;
    private View eVQ;
    private ImageView eVR;
    private g eVS;
    private TextView eVT;
    private String eVU;
    private TextWatcher eVV;
    private View.OnFocusChangeListener eVW;
    private View.OnTouchListener eVX;
    private CommonEmptyView evR;
    private View.OnClickListener exV;
    private View.OnClickListener mClickListener;
    private boolean mHasMore;
    private BdListView mListView;
    private TextView.OnEditorActionListener mOnEditorActionListener;
    private int pn;

    /* loaded from: classes3.dex */
    public interface a {
        void g(com.baidu.live.challenge.d dVar);
    }

    public h(Context context, k kVar) {
        super(context, kVar);
        this.pn = 1;
        this.exV = new View.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.challenge.panel.h.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                h.this.pn = 1;
                if (TextUtils.isEmpty(h.this.eVU)) {
                    h.this.eVv.bn(h.this.pn, 30);
                } else {
                    h.this.eVv.i(h.this.pn, 10, h.this.eVU);
                }
            }
        };
        this.eVK = new a() { // from class: com.baidu.tieba.ala.liveroom.challenge.panel.h.3
            @Override // com.baidu.tieba.ala.liveroom.challenge.panel.h.a
            public void g(com.baidu.live.challenge.d dVar) {
                if (dVar != null) {
                    h.this.eVv.t(dVar.userId);
                }
            }
        };
        this.mClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.challenge.panel.h.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (view != h.this.eVR) {
                    if (view == h.this.eVQ) {
                        h.this.eVP.setText("");
                        return;
                    }
                    return;
                }
                h.this.eVv.bkO();
            }
        };
        this.eVV = new TextWatcher() { // from class: com.baidu.tieba.ala.liveroom.challenge.panel.h.5
            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                h.this.pn = 1;
                if (charSequence == null || charSequence.length() == 0) {
                    h.this.eVU = "";
                    h.this.eVQ.setVisibility(8);
                    h.this.eVv.bn(h.this.pn, 30);
                    return;
                }
                h.this.eVU = charSequence.toString();
                h.this.eVQ.setVisibility(0);
                h.this.eVv.i(h.this.pn, 10, h.this.eVU);
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
            }
        };
        this.eVW = new View.OnFocusChangeListener() { // from class: com.baidu.tieba.ala.liveroom.challenge.panel.h.6
            @Override // android.view.View.OnFocusChangeListener
            public void onFocusChange(View view, boolean z) {
                if (!z) {
                    BdUtilHelper.hideSoftKeyPad(h.this.mContext, view);
                }
            }
        };
        this.mOnEditorActionListener = new TextView.OnEditorActionListener() { // from class: com.baidu.tieba.ala.liveroom.challenge.panel.h.7
            @Override // android.widget.TextView.OnEditorActionListener
            public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
                if (i == 6) {
                    BdUtilHelper.hideSoftKeyPad(h.this.mContext, textView);
                    return true;
                }
                return false;
            }
        };
        this.eVX = new View.OnTouchListener() { // from class: com.baidu.tieba.ala.liveroom.challenge.panel.h.8
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                BdUtilHelper.hideSoftKeyPad(h.this.mContext, view);
                return false;
            }
        };
        this.eVR = (ImageView) this.mRootView.findViewById(a.g.ala_challenge_user_choose_back);
        this.eVR.setOnClickListener(this.mClickListener);
        this.mListView = (BdListView) this.mRootView.findViewById(a.g.ala_challenge_user_list);
        this.eVS = new g(context);
        this.eVS.a(this.eVK);
        this.mListView.setAdapter((ListAdapter) this.eVS);
        this.mListView.setOnSrollToBottomListener(new BdListView.OnScrollToBottomListener() { // from class: com.baidu.tieba.ala.liveroom.challenge.panel.h.2
            @Override // com.baidu.live.adp.widget.listview.BdListView.OnScrollToBottomListener
            public void onScrollToBottom() {
                if (h.this.mHasMore) {
                    if (TextUtils.isEmpty(h.this.eVU)) {
                        h.this.eVv.bn(h.this.pn, 30);
                    } else {
                        h.this.eVv.i(h.this.pn, 10, h.this.eVU);
                    }
                }
            }
        });
        this.eVT = new TextView(this.mContext);
        this.eVT.setTextColor(this.mContext.getResources().getColor(a.d.sdk_white_alpha50));
        this.eVT.setTextSize(0, this.mContext.getResources().getDimensionPixelSize(a.e.sdk_fontsize24));
        this.eVT.setPadding(0, this.mContext.getResources().getDimensionPixelSize(a.e.sdk_ds28), 0, this.mContext.getResources().getDimensionPixelSize(a.e.sdk_ds28));
        this.eVT.setGravity(17);
        this.eVQ = this.mRootView.findViewById(a.g.delete_search_pk_textview);
        this.eVQ.setOnClickListener(this.mClickListener);
        this.eVP = (EditText) this.mRootView.findViewById(a.g.search_pk_edittext);
        this.eVP.addTextChangedListener(this.eVV);
        this.eVP.setOnFocusChangeListener(this.eVW);
        this.eVP.setOnEditorActionListener(this.mOnEditorActionListener);
        this.eVP.setOnTouchListener(this.eVX);
        this.mListView.setOnTouchListener(this.eVX);
        this.mRootView.setOnTouchListener(this.eVX);
    }

    @Override // com.baidu.tieba.ala.liveroom.challenge.panel.e
    protected View createView() {
        return LayoutInflater.from(this.mContext).inflate(a.h.ala_challenge_user_choose_view, (ViewGroup) null);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.ala.liveroom.challenge.panel.e
    public void b(FrameLayout frameLayout, int i) {
        super.b(frameLayout, i);
        this.pn = 1;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.ala.liveroom.challenge.panel.e
    public boolean onBackKeyDown() {
        this.eVv.bkO();
        return true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.ala.liveroom.challenge.panel.e
    public int bkF() {
        return this.mContext.getResources().getDimensionPixelSize(a.e.sdk_ds560) * 2;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.ala.liveroom.challenge.panel.e
    public void bkR() {
        super.bkR();
        BdUtilHelper.hideSoftKeyPad(this.mContext, this.eVP);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.ala.liveroom.challenge.panel.e
    public void hide() {
        super.hide();
        if (this.eVS != null) {
            this.mListView.setSelection(0);
            this.mListView.removeFooterView(this.eVT);
            this.eVS.bkU();
        }
        this.eVP.setText("");
        bcx();
    }

    public void f(com.baidu.live.challenge.d dVar) {
        if (this.eVS != null) {
            this.eVS.e(dVar);
        }
    }

    public void bkV() {
        if (this.eVS != null) {
            this.eVS.notifyDataSetChanged();
        }
    }

    public void a(int i, CommonEmptyView.ImgType imgType) {
        if (this.mContext != null) {
            if (this.evR == null) {
                this.evR = new CommonEmptyView(this.mContext);
                if (this.mRootView instanceof RelativeLayout) {
                    this.evR.addToParent((RelativeLayout) this.mRootView);
                } else if (this.mRootView instanceof FrameLayout) {
                    this.evR.addToParent((FrameLayout) this.mRootView);
                }
            }
            this.evR.setTitle(i);
            this.evR.setup(imgType, CommonEmptyView.StyleType.DARK);
            if (imgType == CommonEmptyView.ImgType.NO_NET || imgType == CommonEmptyView.ImgType.SERVER_ERROR) {
                this.evR.setRefreshButton(a.i.ala_click_retry, this.exV);
            }
            this.evR.setVisibility(0);
        }
    }

    public void bcx() {
        if (this.evR != null) {
            this.evR.setVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void b(com.baidu.live.challenge.b bVar, List<com.baidu.live.challenge.d> list) {
        if (bVar != null && this.mRootView.getParent() != null) {
            if (ListUtils.isEmpty(list) && bVar.pn == 1) {
                this.mListView.setVisibility(8);
                if (TextUtils.isEmpty(this.eVU)) {
                    a(a.i.ala_challenge_empty_challenger, CommonEmptyView.ImgType.NO_DATA);
                    return;
                } else if (TbadkCoreApplication.getInst().isQuanmin()) {
                    a(a.i.ala_challenge_search_empty, CommonEmptyView.ImgType.NO_RANK_LIST);
                    return;
                } else {
                    a(a.i.ala_challenge_search_empty, CommonEmptyView.ImgType.NO_DATA);
                    return;
                }
            }
            this.mListView.setVisibility(0);
            bcx();
            if (bVar.pn == 1) {
                this.eVS.setDatas(list);
            } else {
                this.eVS.bD(list);
            }
            this.pn = bVar.pn + 1;
            this.mHasMore = bVar.hasMore;
            if (bVar.hasMore) {
                bdr();
            } else {
                bds();
            }
        }
    }

    private void bdr() {
        this.eVT.setText(this.mContext.getString(a.i.sdk_loading_text_with_ellipsis));
        this.mListView.removeFooterView(this.eVT);
        this.mListView.addFooterView(this.eVT);
    }

    private void bds() {
        this.eVT.setText(this.mContext.getString(a.i.sdk_list_no_more));
        this.mListView.removeFooterView(this.eVT);
        this.mListView.addFooterView(this.eVT);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void au(int i, String str) {
        BdUtilHelper.showToast(this.mContext, str);
        if (this.eVS.getCount() <= 0 || this.pn == 1) {
            if (this.mListView.getVisibility() == 0) {
                this.mListView.setVisibility(8);
            }
            if (BdNetTypeUtil.isNetWorkAvailable()) {
                a(a.i.sdk_net_fail_tip, CommonEmptyView.ImgType.SERVER_ERROR);
            } else {
                a(a.i.sdk_net_fail_tip, CommonEmptyView.ImgType.NO_NET);
            }
        }
    }
}
