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
import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.live.tbadk.core.util.ListUtils;
import com.baidu.live.tbadk.widget.CommonEmptyView;
import java.util.List;
/* loaded from: classes11.dex */
public class j extends g {
    private TextView bSb;
    private View.OnClickListener bSh;
    private boolean bSs;
    private CommonEmptyView bxT;
    private View.OnFocusChangeListener hxA;
    private View.OnTouchListener hxB;
    public a hxp;
    private EditText hxu;
    private View hxv;
    private ImageView hxw;
    private i hxx;
    private String hxy;
    private TextWatcher hxz;
    private View.OnClickListener mClickListener;
    private boolean mHasMore;
    private BdListView mListView;
    private TextView.OnEditorActionListener mOnEditorActionListener;
    private int pn;

    /* loaded from: classes11.dex */
    public interface a {
        void f(com.baidu.live.challenge.d dVar);
    }

    public j(Context context, n nVar) {
        super(context, nVar);
        this.pn = 1;
        this.bSh = new View.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.challenge.panel.j.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                j.this.pn = 1;
                j.this.bSs = false;
                if (TextUtils.isEmpty(j.this.hxy)) {
                    j.this.hxb.bT(j.this.pn, 30);
                } else {
                    j.this.hxb.k(j.this.pn, 10, j.this.hxy);
                }
            }
        };
        this.hxp = new a() { // from class: com.baidu.tieba.ala.liveroom.challenge.panel.j.3
            @Override // com.baidu.tieba.ala.liveroom.challenge.panel.j.a
            public void f(com.baidu.live.challenge.d dVar) {
                if (dVar != null) {
                    j.this.hxb.aG(dVar.userId);
                }
            }
        };
        this.mClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.challenge.panel.j.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (view != j.this.hxw) {
                    if (view == j.this.hxv) {
                        j.this.hxu.setText("");
                        return;
                    }
                    return;
                }
                j.this.hxb.cgx();
            }
        };
        this.hxz = new TextWatcher() { // from class: com.baidu.tieba.ala.liveroom.challenge.panel.j.5
            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                j.this.pn = 1;
                j.this.bSs = false;
                if (charSequence == null || charSequence.length() == 0) {
                    j.this.hxy = "";
                    j.this.hxv.setVisibility(8);
                    j.this.hxb.bT(j.this.pn, 30);
                    return;
                }
                j.this.hxy = charSequence.toString();
                j.this.hxv.setVisibility(0);
                j.this.hxb.k(j.this.pn, 10, j.this.hxy);
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
            }
        };
        this.hxA = new View.OnFocusChangeListener() { // from class: com.baidu.tieba.ala.liveroom.challenge.panel.j.6
            @Override // android.view.View.OnFocusChangeListener
            public void onFocusChange(View view, boolean z) {
                if (!z) {
                    BdUtilHelper.hideSoftKeyPad(j.this.mContext, view);
                }
            }
        };
        this.mOnEditorActionListener = new TextView.OnEditorActionListener() { // from class: com.baidu.tieba.ala.liveroom.challenge.panel.j.7
            @Override // android.widget.TextView.OnEditorActionListener
            public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
                if (i == 6) {
                    BdUtilHelper.hideSoftKeyPad(j.this.mContext, textView);
                    return true;
                }
                return false;
            }
        };
        this.hxB = new View.OnTouchListener() { // from class: com.baidu.tieba.ala.liveroom.challenge.panel.j.8
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                BdUtilHelper.hideSoftKeyPad(j.this.mContext, view);
                return false;
            }
        };
        this.hxw = (ImageView) this.mRootView.findViewById(a.f.ala_challenge_user_choose_back);
        this.hxw.setOnClickListener(this.mClickListener);
        this.mListView = (BdListView) this.mRootView.findViewById(a.f.ala_challenge_user_list);
        this.hxx = new i(context);
        this.hxx.a(this.hxp);
        this.mListView.setAdapter((ListAdapter) this.hxx);
        this.mListView.setOnSrollToBottomListener(new BdListView.OnScrollToBottomListener() { // from class: com.baidu.tieba.ala.liveroom.challenge.panel.j.2
            @Override // com.baidu.live.adp.widget.listview.BdListView.OnScrollToBottomListener
            public void onScrollToBottom() {
                if (j.this.mHasMore && !j.this.bSs) {
                    j.this.bSs = true;
                    if (TextUtils.isEmpty(j.this.hxy)) {
                        j.this.hxb.bT(j.this.pn, 30);
                    } else {
                        j.this.hxb.k(j.this.pn, 10, j.this.hxy);
                    }
                }
            }
        });
        this.bSb = new TextView(this.mContext);
        this.bSb.setTextColor(this.mContext.getResources().getColor(a.c.sdk_white_alpha50));
        this.bSb.setTextSize(0, this.mContext.getResources().getDimensionPixelSize(a.d.sdk_fontsize24));
        this.bSb.setPadding(0, this.mContext.getResources().getDimensionPixelSize(a.d.sdk_ds28), 0, this.mContext.getResources().getDimensionPixelSize(a.d.sdk_ds28));
        this.bSb.setGravity(17);
        this.hxv = this.mRootView.findViewById(a.f.delete_search_pk_textview);
        this.hxv.setOnClickListener(this.mClickListener);
        this.hxu = (EditText) this.mRootView.findViewById(a.f.search_pk_edittext);
        this.hxu.addTextChangedListener(this.hxz);
        this.hxu.setOnFocusChangeListener(this.hxA);
        this.hxu.setOnEditorActionListener(this.mOnEditorActionListener);
        this.hxu.setOnTouchListener(this.hxB);
        this.mListView.setOnTouchListener(this.hxB);
        this.mRootView.setOnTouchListener(this.hxB);
    }

    @Override // com.baidu.tieba.ala.liveroom.challenge.panel.g
    protected View createView() {
        return LayoutInflater.from(this.mContext).inflate(a.g.ala_challenge_user_choose_view, (ViewGroup) null);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.ala.liveroom.challenge.panel.g
    public void b(FrameLayout frameLayout, int i) {
        super.b(frameLayout, i);
        this.pn = 1;
        this.bSs = false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.ala.liveroom.challenge.panel.g
    public boolean onBackKeyDown() {
        this.hxb.cgx();
        return true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.ala.liveroom.challenge.panel.g
    public int cgj() {
        return this.mContext.getResources().getDimensionPixelSize(a.d.sdk_ds560) * 2;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.ala.liveroom.challenge.panel.g
    public void cgB() {
        super.cgB();
        BdUtilHelper.hideSoftKeyPad(this.mContext, this.hxu);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.ala.liveroom.challenge.panel.g
    public void hide() {
        super.hide();
        if (this.hxx != null) {
            this.mListView.setSelection(0);
            this.mListView.removeFooterView(this.bSb);
            this.hxx.cgE();
        }
        this.hxu.setText("");
        Zj();
    }

    public void j(com.baidu.live.challenge.d dVar) {
        if (this.hxx != null) {
            this.hxx.i(dVar);
        }
    }

    public void cgq() {
        if (this.hxx != null) {
            this.hxx.notifyDataSetChanged();
        }
    }

    public void a(int i, CommonEmptyView.ImgType imgType) {
        if (this.mContext != null) {
            if (this.bxT == null) {
                this.bxT = new CommonEmptyView(this.mContext);
                if (this.mRootView instanceof RelativeLayout) {
                    this.bxT.addToParent((RelativeLayout) this.mRootView);
                } else if (this.mRootView instanceof FrameLayout) {
                    this.bxT.addToParent((FrameLayout) this.mRootView);
                }
            }
            this.bxT.setTitle(i);
            this.bxT.setup(imgType, CommonEmptyView.StyleType.DARK);
            if (imgType == CommonEmptyView.ImgType.NO_NET || imgType == CommonEmptyView.ImgType.SERVER_ERROR) {
                this.bxT.setRefreshButton(a.h.ala_click_retry, this.bSh);
            }
            this.bxT.setVisibility(0);
        }
    }

    public void Zj() {
        if (this.bxT != null) {
            this.bxT.setVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void b(com.baidu.live.challenge.b bVar, List<com.baidu.live.challenge.d> list) {
        this.bSs = false;
        if (bVar != null && this.mRootView.getParent() != null) {
            if (ListUtils.isEmpty(list) && bVar.pn == 1) {
                this.mListView.setVisibility(8);
                if (TextUtils.isEmpty(this.hxy)) {
                    a(a.h.ala_challenge_empty_challenger, CommonEmptyView.ImgType.NO_DATA);
                    return;
                } else if (TbadkCoreApplication.getInst().isQuanmin() || TbadkCoreApplication.getInst().isYinbo()) {
                    a(a.h.ala_challenge_search_empty, CommonEmptyView.ImgType.NO_RANK_LIST);
                    return;
                } else {
                    a(a.h.ala_challenge_search_empty, CommonEmptyView.ImgType.NO_DATA);
                    return;
                }
            }
            this.mListView.setVisibility(0);
            Zj();
            if (bVar.pn == 1) {
                this.hxx.setDatas(list);
            } else {
                this.hxx.cJ(list);
            }
            this.pn = bVar.pn + 1;
            this.mHasMore = bVar.hasMore;
            if (bVar.hasMore) {
                Zh();
            } else {
                Zi();
            }
        }
    }

    private void Zh() {
        this.bSb.setText(this.mContext.getString(a.h.sdk_loading_text_with_ellipsis));
        this.mListView.removeFooterView(this.bSb);
        this.mListView.addFooterView(this.bSb);
    }

    private void Zi() {
        this.bSb.setText(this.mContext.getString(a.h.sdk_list_no_more));
        this.mListView.removeFooterView(this.bSb);
        this.mListView.addFooterView(this.bSb);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void bh(int i, String str) {
        this.bSs = false;
        BdUtilHelper.showToast(this.mContext, str);
        if (this.hxx.getCount() <= 0 || this.pn == 1) {
            if (this.mListView.getVisibility() == 0) {
                this.mListView.setVisibility(8);
            }
            if (BdNetTypeUtil.isNetWorkAvailable()) {
                a(a.h.sdk_net_fail_tip, CommonEmptyView.ImgType.SERVER_ERROR);
            } else {
                a(a.h.sdk_net_fail_tip, CommonEmptyView.ImgType.NO_NET);
            }
        }
    }
}
