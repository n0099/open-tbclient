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
/* loaded from: classes4.dex */
public class j extends g {
    private boolean bNF;
    private TextView bNo;
    private View.OnClickListener bNu;
    private CommonEmptyView btg;
    private View hlA;
    private ImageView hlB;
    private i hlC;
    private String hlD;
    private TextWatcher hlE;
    private View.OnFocusChangeListener hlF;
    private View.OnTouchListener hlG;
    public a hlu;
    private EditText hlz;
    private View.OnClickListener mClickListener;
    private boolean mHasMore;
    private BdListView mListView;
    private TextView.OnEditorActionListener mOnEditorActionListener;
    private int pn;

    /* loaded from: classes4.dex */
    public interface a {
        void f(com.baidu.live.challenge.d dVar);
    }

    public j(Context context, n nVar) {
        super(context, nVar);
        this.pn = 1;
        this.bNu = new View.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.challenge.panel.j.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                j.this.pn = 1;
                j.this.bNF = false;
                if (TextUtils.isEmpty(j.this.hlD)) {
                    j.this.hlg.bU(j.this.pn, 30);
                } else {
                    j.this.hlg.k(j.this.pn, 10, j.this.hlD);
                }
            }
        };
        this.hlu = new a() { // from class: com.baidu.tieba.ala.liveroom.challenge.panel.j.3
            @Override // com.baidu.tieba.ala.liveroom.challenge.panel.j.a
            public void f(com.baidu.live.challenge.d dVar) {
                if (dVar != null) {
                    j.this.hlg.aH(dVar.userId);
                }
            }
        };
        this.mClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.challenge.panel.j.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (view != j.this.hlB) {
                    if (view == j.this.hlA) {
                        j.this.hlz.setText("");
                        return;
                    }
                    return;
                }
                j.this.hlg.cdG();
            }
        };
        this.hlE = new TextWatcher() { // from class: com.baidu.tieba.ala.liveroom.challenge.panel.j.5
            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                j.this.pn = 1;
                j.this.bNF = false;
                if (charSequence == null || charSequence.length() == 0) {
                    j.this.hlD = "";
                    j.this.hlA.setVisibility(8);
                    j.this.hlg.bU(j.this.pn, 30);
                    return;
                }
                j.this.hlD = charSequence.toString();
                j.this.hlA.setVisibility(0);
                j.this.hlg.k(j.this.pn, 10, j.this.hlD);
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
            }
        };
        this.hlF = new View.OnFocusChangeListener() { // from class: com.baidu.tieba.ala.liveroom.challenge.panel.j.6
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
        this.hlG = new View.OnTouchListener() { // from class: com.baidu.tieba.ala.liveroom.challenge.panel.j.8
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                BdUtilHelper.hideSoftKeyPad(j.this.mContext, view);
                return false;
            }
        };
        this.hlB = (ImageView) this.mRootView.findViewById(a.f.ala_challenge_user_choose_back);
        this.hlB.setOnClickListener(this.mClickListener);
        this.mListView = (BdListView) this.mRootView.findViewById(a.f.ala_challenge_user_list);
        this.hlC = new i(context);
        this.hlC.a(this.hlu);
        this.mListView.setAdapter((ListAdapter) this.hlC);
        this.mListView.setOnSrollToBottomListener(new BdListView.OnScrollToBottomListener() { // from class: com.baidu.tieba.ala.liveroom.challenge.panel.j.2
            @Override // com.baidu.live.adp.widget.listview.BdListView.OnScrollToBottomListener
            public void onScrollToBottom() {
                if (j.this.mHasMore && !j.this.bNF) {
                    j.this.bNF = true;
                    if (TextUtils.isEmpty(j.this.hlD)) {
                        j.this.hlg.bU(j.this.pn, 30);
                    } else {
                        j.this.hlg.k(j.this.pn, 10, j.this.hlD);
                    }
                }
            }
        });
        this.bNo = new TextView(this.mContext);
        this.bNo.setTextColor(this.mContext.getResources().getColor(a.c.sdk_white_alpha50));
        this.bNo.setTextSize(0, this.mContext.getResources().getDimensionPixelSize(a.d.sdk_fontsize24));
        this.bNo.setPadding(0, this.mContext.getResources().getDimensionPixelSize(a.d.sdk_ds28), 0, this.mContext.getResources().getDimensionPixelSize(a.d.sdk_ds28));
        this.bNo.setGravity(17);
        this.hlA = this.mRootView.findViewById(a.f.delete_search_pk_textview);
        this.hlA.setOnClickListener(this.mClickListener);
        this.hlz = (EditText) this.mRootView.findViewById(a.f.search_pk_edittext);
        this.hlz.addTextChangedListener(this.hlE);
        this.hlz.setOnFocusChangeListener(this.hlF);
        this.hlz.setOnEditorActionListener(this.mOnEditorActionListener);
        this.hlz.setOnTouchListener(this.hlG);
        this.mListView.setOnTouchListener(this.hlG);
        this.mRootView.setOnTouchListener(this.hlG);
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
        this.bNF = false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.ala.liveroom.challenge.panel.g
    public boolean onBackKeyDown() {
        this.hlg.cdG();
        return true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.ala.liveroom.challenge.panel.g
    public int cds() {
        return this.mContext.getResources().getDimensionPixelSize(a.d.sdk_ds560) * 2;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.ala.liveroom.challenge.panel.g
    public void cdK() {
        super.cdK();
        BdUtilHelper.hideSoftKeyPad(this.mContext, this.hlz);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.ala.liveroom.challenge.panel.g
    public void hide() {
        super.hide();
        if (this.hlC != null) {
            this.mListView.setSelection(0);
            this.mListView.removeFooterView(this.bNo);
            this.hlC.cdN();
        }
        this.hlz.setText("");
        Yb();
    }

    public void j(com.baidu.live.challenge.d dVar) {
        if (this.hlC != null) {
            this.hlC.i(dVar);
        }
    }

    public void cdz() {
        if (this.hlC != null) {
            this.hlC.notifyDataSetChanged();
        }
    }

    public void a(int i, CommonEmptyView.ImgType imgType) {
        if (this.mContext != null) {
            if (this.btg == null) {
                this.btg = new CommonEmptyView(this.mContext);
                if (this.mRootView instanceof RelativeLayout) {
                    this.btg.addToParent((RelativeLayout) this.mRootView);
                } else if (this.mRootView instanceof FrameLayout) {
                    this.btg.addToParent((FrameLayout) this.mRootView);
                }
            }
            this.btg.setTitle(i);
            this.btg.setup(imgType, CommonEmptyView.StyleType.DARK);
            if (imgType == CommonEmptyView.ImgType.NO_NET || imgType == CommonEmptyView.ImgType.SERVER_ERROR) {
                this.btg.setRefreshButton(a.h.ala_click_retry, this.bNu);
            }
            this.btg.setVisibility(0);
        }
    }

    public void Yb() {
        if (this.btg != null) {
            this.btg.setVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void b(com.baidu.live.challenge.b bVar, List<com.baidu.live.challenge.d> list) {
        this.bNF = false;
        if (bVar != null && this.mRootView.getParent() != null) {
            if (ListUtils.isEmpty(list) && bVar.pn == 1) {
                this.mListView.setVisibility(8);
                if (TextUtils.isEmpty(this.hlD)) {
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
            Yb();
            if (bVar.pn == 1) {
                this.hlC.setDatas(list);
            } else {
                this.hlC.cC(list);
            }
            this.pn = bVar.pn + 1;
            this.mHasMore = bVar.hasMore;
            if (bVar.hasMore) {
                XZ();
            } else {
                Ya();
            }
        }
    }

    private void XZ() {
        this.bNo.setText(this.mContext.getString(a.h.sdk_loading_text_with_ellipsis));
        this.mListView.removeFooterView(this.bNo);
        this.mListView.addFooterView(this.bNo);
    }

    private void Ya() {
        this.bNo.setText(this.mContext.getString(a.h.sdk_list_no_more));
        this.mListView.removeFooterView(this.bNo);
        this.mListView.addFooterView(this.bNo);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void bf(int i, String str) {
        this.bNF = false;
        BdUtilHelper.showToast(this.mContext, str);
        if (this.hlC.getCount() <= 0 || this.pn == 1) {
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
