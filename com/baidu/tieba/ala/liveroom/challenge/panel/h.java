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
    public a eVJ;
    private EditText eVO;
    private View eVP;
    private ImageView eVQ;
    private g eVR;
    private TextView eVS;
    private String eVT;
    private TextWatcher eVU;
    private View.OnFocusChangeListener eVV;
    private View.OnTouchListener eVW;
    private CommonEmptyView evQ;
    private View.OnClickListener exU;
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
        this.exU = new View.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.challenge.panel.h.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                h.this.pn = 1;
                if (TextUtils.isEmpty(h.this.eVT)) {
                    h.this.eVu.bn(h.this.pn, 30);
                } else {
                    h.this.eVu.i(h.this.pn, 10, h.this.eVT);
                }
            }
        };
        this.eVJ = new a() { // from class: com.baidu.tieba.ala.liveroom.challenge.panel.h.3
            @Override // com.baidu.tieba.ala.liveroom.challenge.panel.h.a
            public void g(com.baidu.live.challenge.d dVar) {
                if (dVar != null) {
                    h.this.eVu.t(dVar.userId);
                }
            }
        };
        this.mClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.challenge.panel.h.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (view != h.this.eVQ) {
                    if (view == h.this.eVP) {
                        h.this.eVO.setText("");
                        return;
                    }
                    return;
                }
                h.this.eVu.bkM();
            }
        };
        this.eVU = new TextWatcher() { // from class: com.baidu.tieba.ala.liveroom.challenge.panel.h.5
            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                h.this.pn = 1;
                if (charSequence == null || charSequence.length() == 0) {
                    h.this.eVT = "";
                    h.this.eVP.setVisibility(8);
                    h.this.eVu.bn(h.this.pn, 30);
                    return;
                }
                h.this.eVT = charSequence.toString();
                h.this.eVP.setVisibility(0);
                h.this.eVu.i(h.this.pn, 10, h.this.eVT);
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
            }
        };
        this.eVV = new View.OnFocusChangeListener() { // from class: com.baidu.tieba.ala.liveroom.challenge.panel.h.6
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
        this.eVW = new View.OnTouchListener() { // from class: com.baidu.tieba.ala.liveroom.challenge.panel.h.8
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                BdUtilHelper.hideSoftKeyPad(h.this.mContext, view);
                return false;
            }
        };
        this.eVQ = (ImageView) this.mRootView.findViewById(a.g.ala_challenge_user_choose_back);
        this.eVQ.setOnClickListener(this.mClickListener);
        this.mListView = (BdListView) this.mRootView.findViewById(a.g.ala_challenge_user_list);
        this.eVR = new g(context);
        this.eVR.a(this.eVJ);
        this.mListView.setAdapter((ListAdapter) this.eVR);
        this.mListView.setOnSrollToBottomListener(new BdListView.OnScrollToBottomListener() { // from class: com.baidu.tieba.ala.liveroom.challenge.panel.h.2
            @Override // com.baidu.live.adp.widget.listview.BdListView.OnScrollToBottomListener
            public void onScrollToBottom() {
                if (h.this.mHasMore) {
                    if (TextUtils.isEmpty(h.this.eVT)) {
                        h.this.eVu.bn(h.this.pn, 30);
                    } else {
                        h.this.eVu.i(h.this.pn, 10, h.this.eVT);
                    }
                }
            }
        });
        this.eVS = new TextView(this.mContext);
        this.eVS.setTextColor(this.mContext.getResources().getColor(a.d.sdk_white_alpha50));
        this.eVS.setTextSize(0, this.mContext.getResources().getDimensionPixelSize(a.e.sdk_fontsize24));
        this.eVS.setPadding(0, this.mContext.getResources().getDimensionPixelSize(a.e.sdk_ds28), 0, this.mContext.getResources().getDimensionPixelSize(a.e.sdk_ds28));
        this.eVS.setGravity(17);
        this.eVP = this.mRootView.findViewById(a.g.delete_search_pk_textview);
        this.eVP.setOnClickListener(this.mClickListener);
        this.eVO = (EditText) this.mRootView.findViewById(a.g.search_pk_edittext);
        this.eVO.addTextChangedListener(this.eVU);
        this.eVO.setOnFocusChangeListener(this.eVV);
        this.eVO.setOnEditorActionListener(this.mOnEditorActionListener);
        this.eVO.setOnTouchListener(this.eVW);
        this.mListView.setOnTouchListener(this.eVW);
        this.mRootView.setOnTouchListener(this.eVW);
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
        this.eVu.bkM();
        return true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.ala.liveroom.challenge.panel.e
    public int bkD() {
        return this.mContext.getResources().getDimensionPixelSize(a.e.sdk_ds560) * 2;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.ala.liveroom.challenge.panel.e
    public void bkP() {
        super.bkP();
        BdUtilHelper.hideSoftKeyPad(this.mContext, this.eVO);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.ala.liveroom.challenge.panel.e
    public void hide() {
        super.hide();
        if (this.eVR != null) {
            this.mListView.setSelection(0);
            this.mListView.removeFooterView(this.eVS);
            this.eVR.bkS();
        }
        this.eVO.setText("");
        bcv();
    }

    public void f(com.baidu.live.challenge.d dVar) {
        if (this.eVR != null) {
            this.eVR.e(dVar);
        }
    }

    public void bkT() {
        if (this.eVR != null) {
            this.eVR.notifyDataSetChanged();
        }
    }

    public void a(int i, CommonEmptyView.ImgType imgType) {
        if (this.mContext != null) {
            if (this.evQ == null) {
                this.evQ = new CommonEmptyView(this.mContext);
                if (this.mRootView instanceof RelativeLayout) {
                    this.evQ.addToParent((RelativeLayout) this.mRootView);
                } else if (this.mRootView instanceof FrameLayout) {
                    this.evQ.addToParent((FrameLayout) this.mRootView);
                }
            }
            this.evQ.setTitle(i);
            this.evQ.setup(imgType, CommonEmptyView.StyleType.DARK);
            if (imgType == CommonEmptyView.ImgType.NO_NET || imgType == CommonEmptyView.ImgType.SERVER_ERROR) {
                this.evQ.setRefreshButton(a.i.ala_click_retry, this.exU);
            }
            this.evQ.setVisibility(0);
        }
    }

    public void bcv() {
        if (this.evQ != null) {
            this.evQ.setVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void b(com.baidu.live.challenge.b bVar, List<com.baidu.live.challenge.d> list) {
        if (bVar != null && this.mRootView.getParent() != null) {
            if (ListUtils.isEmpty(list) && bVar.pn == 1) {
                this.mListView.setVisibility(8);
                if (TextUtils.isEmpty(this.eVT)) {
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
            bcv();
            if (bVar.pn == 1) {
                this.eVR.setDatas(list);
            } else {
                this.eVR.bD(list);
            }
            this.pn = bVar.pn + 1;
            this.mHasMore = bVar.hasMore;
            if (bVar.hasMore) {
                bdp();
            } else {
                bdq();
            }
        }
    }

    private void bdp() {
        this.eVS.setText(this.mContext.getString(a.i.sdk_loading_text_with_ellipsis));
        this.mListView.removeFooterView(this.eVS);
        this.mListView.addFooterView(this.eVS);
    }

    private void bdq() {
        this.eVS.setText(this.mContext.getString(a.i.sdk_list_no_more));
        this.mListView.removeFooterView(this.eVS);
        this.mListView.addFooterView(this.eVS);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void au(int i, String str) {
        BdUtilHelper.showToast(this.mContext, str);
        if (this.eVR.getCount() <= 0 || this.pn == 1) {
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
