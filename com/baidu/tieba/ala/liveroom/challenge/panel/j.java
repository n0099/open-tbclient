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
    private TextView bIg;
    private View.OnClickListener bIm;
    private boolean bIx;
    private CommonEmptyView bnY;
    public a hbJ;
    private EditText hbO;
    private View hbP;
    private ImageView hbQ;
    private i hbR;
    private String hbS;
    private TextWatcher hbT;
    private View.OnFocusChangeListener hbU;
    private View.OnTouchListener hbV;
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
        this.bIm = new View.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.challenge.panel.j.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                j.this.pn = 1;
                j.this.bIx = false;
                if (TextUtils.isEmpty(j.this.hbS)) {
                    j.this.hbv.bQ(j.this.pn, 30);
                } else {
                    j.this.hbv.j(j.this.pn, 10, j.this.hbS);
                }
            }
        };
        this.hbJ = new a() { // from class: com.baidu.tieba.ala.liveroom.challenge.panel.j.3
            @Override // com.baidu.tieba.ala.liveroom.challenge.panel.j.a
            public void f(com.baidu.live.challenge.d dVar) {
                if (dVar != null) {
                    j.this.hbv.aj(dVar.userId);
                }
            }
        };
        this.mClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.challenge.panel.j.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (view != j.this.hbQ) {
                    if (view == j.this.hbP) {
                        j.this.hbO.setText("");
                        return;
                    }
                    return;
                }
                j.this.hbv.bZK();
            }
        };
        this.hbT = new TextWatcher() { // from class: com.baidu.tieba.ala.liveroom.challenge.panel.j.5
            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                j.this.pn = 1;
                j.this.bIx = false;
                if (charSequence == null || charSequence.length() == 0) {
                    j.this.hbS = "";
                    j.this.hbP.setVisibility(8);
                    j.this.hbv.bQ(j.this.pn, 30);
                    return;
                }
                j.this.hbS = charSequence.toString();
                j.this.hbP.setVisibility(0);
                j.this.hbv.j(j.this.pn, 10, j.this.hbS);
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
            }
        };
        this.hbU = new View.OnFocusChangeListener() { // from class: com.baidu.tieba.ala.liveroom.challenge.panel.j.6
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
        this.hbV = new View.OnTouchListener() { // from class: com.baidu.tieba.ala.liveroom.challenge.panel.j.8
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                BdUtilHelper.hideSoftKeyPad(j.this.mContext, view);
                return false;
            }
        };
        this.hbQ = (ImageView) this.mRootView.findViewById(a.f.ala_challenge_user_choose_back);
        this.hbQ.setOnClickListener(this.mClickListener);
        this.mListView = (BdListView) this.mRootView.findViewById(a.f.ala_challenge_user_list);
        this.hbR = new i(context);
        this.hbR.a(this.hbJ);
        this.mListView.setAdapter((ListAdapter) this.hbR);
        this.mListView.setOnSrollToBottomListener(new BdListView.OnScrollToBottomListener() { // from class: com.baidu.tieba.ala.liveroom.challenge.panel.j.2
            @Override // com.baidu.live.adp.widget.listview.BdListView.OnScrollToBottomListener
            public void onScrollToBottom() {
                if (j.this.mHasMore && !j.this.bIx) {
                    j.this.bIx = true;
                    if (TextUtils.isEmpty(j.this.hbS)) {
                        j.this.hbv.bQ(j.this.pn, 30);
                    } else {
                        j.this.hbv.j(j.this.pn, 10, j.this.hbS);
                    }
                }
            }
        });
        this.bIg = new TextView(this.mContext);
        this.bIg.setTextColor(this.mContext.getResources().getColor(a.c.sdk_white_alpha50));
        this.bIg.setTextSize(0, this.mContext.getResources().getDimensionPixelSize(a.d.sdk_fontsize24));
        this.bIg.setPadding(0, this.mContext.getResources().getDimensionPixelSize(a.d.sdk_ds28), 0, this.mContext.getResources().getDimensionPixelSize(a.d.sdk_ds28));
        this.bIg.setGravity(17);
        this.hbP = this.mRootView.findViewById(a.f.delete_search_pk_textview);
        this.hbP.setOnClickListener(this.mClickListener);
        this.hbO = (EditText) this.mRootView.findViewById(a.f.search_pk_edittext);
        this.hbO.addTextChangedListener(this.hbT);
        this.hbO.setOnFocusChangeListener(this.hbU);
        this.hbO.setOnEditorActionListener(this.mOnEditorActionListener);
        this.hbO.setOnTouchListener(this.hbV);
        this.mListView.setOnTouchListener(this.hbV);
        this.mRootView.setOnTouchListener(this.hbV);
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
        this.bIx = false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.ala.liveroom.challenge.panel.g
    public boolean onBackKeyDown() {
        this.hbv.bZK();
        return true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.ala.liveroom.challenge.panel.g
    public int bZw() {
        return this.mContext.getResources().getDimensionPixelSize(a.d.sdk_ds560) * 2;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.ala.liveroom.challenge.panel.g
    public void bZO() {
        super.bZO();
        BdUtilHelper.hideSoftKeyPad(this.mContext, this.hbO);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.ala.liveroom.challenge.panel.g
    public void hide() {
        super.hide();
        if (this.hbR != null) {
            this.mListView.setSelection(0);
            this.mListView.removeFooterView(this.bIg);
            this.hbR.bZR();
        }
        this.hbO.setText("");
        VB();
    }

    public void j(com.baidu.live.challenge.d dVar) {
        if (this.hbR != null) {
            this.hbR.i(dVar);
        }
    }

    public void bZD() {
        if (this.hbR != null) {
            this.hbR.notifyDataSetChanged();
        }
    }

    public void a(int i, CommonEmptyView.ImgType imgType) {
        if (this.mContext != null) {
            if (this.bnY == null) {
                this.bnY = new CommonEmptyView(this.mContext);
                if (this.mRootView instanceof RelativeLayout) {
                    this.bnY.addToParent((RelativeLayout) this.mRootView);
                } else if (this.mRootView instanceof FrameLayout) {
                    this.bnY.addToParent((FrameLayout) this.mRootView);
                }
            }
            this.bnY.setTitle(i);
            this.bnY.setup(imgType, CommonEmptyView.StyleType.DARK);
            if (imgType == CommonEmptyView.ImgType.NO_NET || imgType == CommonEmptyView.ImgType.SERVER_ERROR) {
                this.bnY.setRefreshButton(a.h.ala_click_retry, this.bIm);
            }
            this.bnY.setVisibility(0);
        }
    }

    public void VB() {
        if (this.bnY != null) {
            this.bnY.setVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void b(com.baidu.live.challenge.b bVar, List<com.baidu.live.challenge.d> list) {
        this.bIx = false;
        if (bVar != null && this.mRootView.getParent() != null) {
            if (ListUtils.isEmpty(list) && bVar.pn == 1) {
                this.mListView.setVisibility(8);
                if (TextUtils.isEmpty(this.hbS)) {
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
            VB();
            if (bVar.pn == 1) {
                this.hbR.setDatas(list);
            } else {
                this.hbR.cy(list);
            }
            this.pn = bVar.pn + 1;
            this.mHasMore = bVar.hasMore;
            if (bVar.hasMore) {
                Vz();
            } else {
                VA();
            }
        }
    }

    private void Vz() {
        this.bIg.setText(this.mContext.getString(a.h.sdk_loading_text_with_ellipsis));
        this.mListView.removeFooterView(this.bIg);
        this.mListView.addFooterView(this.bIg);
    }

    private void VA() {
        this.bIg.setText(this.mContext.getString(a.h.sdk_list_no_more));
        this.mListView.removeFooterView(this.bIg);
        this.mListView.addFooterView(this.bIg);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void bf(int i, String str) {
        this.bIx = false;
        BdUtilHelper.showToast(this.mContext, str);
        if (this.hbR.getCount() <= 0 || this.pn == 1) {
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
