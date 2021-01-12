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
/* loaded from: classes10.dex */
public class j extends g {
    private boolean bNG;
    private TextView bNp;
    private View.OnClickListener bNv;
    private CommonEmptyView btf;
    public a hsJ;
    private EditText hsO;
    private View hsP;
    private ImageView hsQ;
    private i hsR;
    private String hsS;
    private TextWatcher hsT;
    private View.OnFocusChangeListener hsU;
    private View.OnTouchListener hsV;
    private View.OnClickListener mClickListener;
    private boolean mHasMore;
    private BdListView mListView;
    private TextView.OnEditorActionListener mOnEditorActionListener;
    private int pn;

    /* loaded from: classes10.dex */
    public interface a {
        void f(com.baidu.live.challenge.d dVar);
    }

    public j(Context context, n nVar) {
        super(context, nVar);
        this.pn = 1;
        this.bNv = new View.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.challenge.panel.j.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                j.this.pn = 1;
                j.this.bNG = false;
                if (TextUtils.isEmpty(j.this.hsS)) {
                    j.this.hsv.bT(j.this.pn, 30);
                } else {
                    j.this.hsv.k(j.this.pn, 10, j.this.hsS);
                }
            }
        };
        this.hsJ = new a() { // from class: com.baidu.tieba.ala.liveroom.challenge.panel.j.3
            @Override // com.baidu.tieba.ala.liveroom.challenge.panel.j.a
            public void f(com.baidu.live.challenge.d dVar) {
                if (dVar != null) {
                    j.this.hsv.aG(dVar.userId);
                }
            }
        };
        this.mClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.challenge.panel.j.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (view != j.this.hsQ) {
                    if (view == j.this.hsP) {
                        j.this.hsO.setText("");
                        return;
                    }
                    return;
                }
                j.this.hsv.ccF();
            }
        };
        this.hsT = new TextWatcher() { // from class: com.baidu.tieba.ala.liveroom.challenge.panel.j.5
            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                j.this.pn = 1;
                j.this.bNG = false;
                if (charSequence == null || charSequence.length() == 0) {
                    j.this.hsS = "";
                    j.this.hsP.setVisibility(8);
                    j.this.hsv.bT(j.this.pn, 30);
                    return;
                }
                j.this.hsS = charSequence.toString();
                j.this.hsP.setVisibility(0);
                j.this.hsv.k(j.this.pn, 10, j.this.hsS);
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
            }
        };
        this.hsU = new View.OnFocusChangeListener() { // from class: com.baidu.tieba.ala.liveroom.challenge.panel.j.6
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
        this.hsV = new View.OnTouchListener() { // from class: com.baidu.tieba.ala.liveroom.challenge.panel.j.8
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                BdUtilHelper.hideSoftKeyPad(j.this.mContext, view);
                return false;
            }
        };
        this.hsQ = (ImageView) this.mRootView.findViewById(a.f.ala_challenge_user_choose_back);
        this.hsQ.setOnClickListener(this.mClickListener);
        this.mListView = (BdListView) this.mRootView.findViewById(a.f.ala_challenge_user_list);
        this.hsR = new i(context);
        this.hsR.a(this.hsJ);
        this.mListView.setAdapter((ListAdapter) this.hsR);
        this.mListView.setOnSrollToBottomListener(new BdListView.OnScrollToBottomListener() { // from class: com.baidu.tieba.ala.liveroom.challenge.panel.j.2
            @Override // com.baidu.live.adp.widget.listview.BdListView.OnScrollToBottomListener
            public void onScrollToBottom() {
                if (j.this.mHasMore && !j.this.bNG) {
                    j.this.bNG = true;
                    if (TextUtils.isEmpty(j.this.hsS)) {
                        j.this.hsv.bT(j.this.pn, 30);
                    } else {
                        j.this.hsv.k(j.this.pn, 10, j.this.hsS);
                    }
                }
            }
        });
        this.bNp = new TextView(this.mContext);
        this.bNp.setTextColor(this.mContext.getResources().getColor(a.c.sdk_white_alpha50));
        this.bNp.setTextSize(0, this.mContext.getResources().getDimensionPixelSize(a.d.sdk_fontsize24));
        this.bNp.setPadding(0, this.mContext.getResources().getDimensionPixelSize(a.d.sdk_ds28), 0, this.mContext.getResources().getDimensionPixelSize(a.d.sdk_ds28));
        this.bNp.setGravity(17);
        this.hsP = this.mRootView.findViewById(a.f.delete_search_pk_textview);
        this.hsP.setOnClickListener(this.mClickListener);
        this.hsO = (EditText) this.mRootView.findViewById(a.f.search_pk_edittext);
        this.hsO.addTextChangedListener(this.hsT);
        this.hsO.setOnFocusChangeListener(this.hsU);
        this.hsO.setOnEditorActionListener(this.mOnEditorActionListener);
        this.hsO.setOnTouchListener(this.hsV);
        this.mListView.setOnTouchListener(this.hsV);
        this.mRootView.setOnTouchListener(this.hsV);
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
        this.bNG = false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.ala.liveroom.challenge.panel.g
    public boolean onBackKeyDown() {
        this.hsv.ccF();
        return true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.ala.liveroom.challenge.panel.g
    public int ccr() {
        return this.mContext.getResources().getDimensionPixelSize(a.d.sdk_ds560) * 2;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.ala.liveroom.challenge.panel.g
    public void ccJ() {
        super.ccJ();
        BdUtilHelper.hideSoftKeyPad(this.mContext, this.hsO);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.ala.liveroom.challenge.panel.g
    public void hide() {
        super.hide();
        if (this.hsR != null) {
            this.mListView.setSelection(0);
            this.mListView.removeFooterView(this.bNp);
            this.hsR.ccM();
        }
        this.hsO.setText("");
        Vq();
    }

    public void j(com.baidu.live.challenge.d dVar) {
        if (this.hsR != null) {
            this.hsR.i(dVar);
        }
    }

    public void ccy() {
        if (this.hsR != null) {
            this.hsR.notifyDataSetChanged();
        }
    }

    public void a(int i, CommonEmptyView.ImgType imgType) {
        if (this.mContext != null) {
            if (this.btf == null) {
                this.btf = new CommonEmptyView(this.mContext);
                if (this.mRootView instanceof RelativeLayout) {
                    this.btf.addToParent((RelativeLayout) this.mRootView);
                } else if (this.mRootView instanceof FrameLayout) {
                    this.btf.addToParent((FrameLayout) this.mRootView);
                }
            }
            this.btf.setTitle(i);
            this.btf.setup(imgType, CommonEmptyView.StyleType.DARK);
            if (imgType == CommonEmptyView.ImgType.NO_NET || imgType == CommonEmptyView.ImgType.SERVER_ERROR) {
                this.btf.setRefreshButton(a.h.ala_click_retry, this.bNv);
            }
            this.btf.setVisibility(0);
        }
    }

    public void Vq() {
        if (this.btf != null) {
            this.btf.setVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void b(com.baidu.live.challenge.b bVar, List<com.baidu.live.challenge.d> list) {
        this.bNG = false;
        if (bVar != null && this.mRootView.getParent() != null) {
            if (ListUtils.isEmpty(list) && bVar.pn == 1) {
                this.mListView.setVisibility(8);
                if (TextUtils.isEmpty(this.hsS)) {
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
            Vq();
            if (bVar.pn == 1) {
                this.hsR.setDatas(list);
            } else {
                this.hsR.cJ(list);
            }
            this.pn = bVar.pn + 1;
            this.mHasMore = bVar.hasMore;
            if (bVar.hasMore) {
                Vo();
            } else {
                Vp();
            }
        }
    }

    private void Vo() {
        this.bNp.setText(this.mContext.getString(a.h.sdk_loading_text_with_ellipsis));
        this.mListView.removeFooterView(this.bNp);
        this.mListView.addFooterView(this.bNp);
    }

    private void Vp() {
        this.bNp.setText(this.mContext.getString(a.h.sdk_list_no_more));
        this.mListView.removeFooterView(this.bNp);
        this.mListView.addFooterView(this.bNp);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void bi(int i, String str) {
        this.bNG = false;
        BdUtilHelper.showToast(this.mContext, str);
        if (this.hsR.getCount() <= 0 || this.pn == 1) {
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
