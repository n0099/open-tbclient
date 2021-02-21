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
    private TextView bRf;
    private View.OnClickListener bRl;
    private boolean bRw;
    private CommonEmptyView bwJ;
    public a hxh;
    private EditText hxm;
    private View hxn;
    private ImageView hxo;
    private i hxp;
    private String hxq;
    private TextWatcher hxr;
    private View.OnFocusChangeListener hxs;
    private View.OnTouchListener hxt;
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
        this.bRl = new View.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.challenge.panel.j.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                j.this.pn = 1;
                j.this.bRw = false;
                if (TextUtils.isEmpty(j.this.hxq)) {
                    j.this.hwT.bR(j.this.pn, 30);
                } else {
                    j.this.hwT.j(j.this.pn, 10, j.this.hxq);
                }
            }
        };
        this.hxh = new a() { // from class: com.baidu.tieba.ala.liveroom.challenge.panel.j.3
            @Override // com.baidu.tieba.ala.liveroom.challenge.panel.j.a
            public void f(com.baidu.live.challenge.d dVar) {
                if (dVar != null) {
                    j.this.hwT.aI(dVar.userId);
                }
            }
        };
        this.mClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.challenge.panel.j.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (view != j.this.hxo) {
                    if (view == j.this.hxn) {
                        j.this.hxm.setText("");
                        return;
                    }
                    return;
                }
                j.this.hwT.cdH();
            }
        };
        this.hxr = new TextWatcher() { // from class: com.baidu.tieba.ala.liveroom.challenge.panel.j.5
            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                j.this.pn = 1;
                j.this.bRw = false;
                if (charSequence == null || charSequence.length() == 0) {
                    j.this.hxq = "";
                    j.this.hxn.setVisibility(8);
                    j.this.hwT.bR(j.this.pn, 30);
                    return;
                }
                j.this.hxq = charSequence.toString();
                j.this.hxn.setVisibility(0);
                j.this.hwT.j(j.this.pn, 10, j.this.hxq);
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
            }
        };
        this.hxs = new View.OnFocusChangeListener() { // from class: com.baidu.tieba.ala.liveroom.challenge.panel.j.6
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
        this.hxt = new View.OnTouchListener() { // from class: com.baidu.tieba.ala.liveroom.challenge.panel.j.8
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                BdUtilHelper.hideSoftKeyPad(j.this.mContext, view);
                return false;
            }
        };
        this.hxo = (ImageView) this.mRootView.findViewById(a.f.ala_challenge_user_choose_back);
        this.hxo.setOnClickListener(this.mClickListener);
        this.mListView = (BdListView) this.mRootView.findViewById(a.f.ala_challenge_user_list);
        this.hxp = new i(context);
        this.hxp.a(this.hxh);
        this.mListView.setAdapter((ListAdapter) this.hxp);
        this.mListView.setOnSrollToBottomListener(new BdListView.OnScrollToBottomListener() { // from class: com.baidu.tieba.ala.liveroom.challenge.panel.j.2
            @Override // com.baidu.live.adp.widget.listview.BdListView.OnScrollToBottomListener
            public void onScrollToBottom() {
                if (j.this.mHasMore && !j.this.bRw) {
                    j.this.bRw = true;
                    if (TextUtils.isEmpty(j.this.hxq)) {
                        j.this.hwT.bR(j.this.pn, 30);
                    } else {
                        j.this.hwT.j(j.this.pn, 10, j.this.hxq);
                    }
                }
            }
        });
        this.bRf = new TextView(this.mContext);
        this.bRf.setTextColor(this.mContext.getResources().getColor(a.c.sdk_white_alpha50));
        this.bRf.setTextSize(0, this.mContext.getResources().getDimensionPixelSize(a.d.sdk_fontsize24));
        this.bRf.setPadding(0, this.mContext.getResources().getDimensionPixelSize(a.d.sdk_ds28), 0, this.mContext.getResources().getDimensionPixelSize(a.d.sdk_ds28));
        this.bRf.setGravity(17);
        this.hxn = this.mRootView.findViewById(a.f.delete_search_pk_textview);
        this.hxn.setOnClickListener(this.mClickListener);
        this.hxm = (EditText) this.mRootView.findViewById(a.f.search_pk_edittext);
        this.hxm.addTextChangedListener(this.hxr);
        this.hxm.setOnFocusChangeListener(this.hxs);
        this.hxm.setOnEditorActionListener(this.mOnEditorActionListener);
        this.hxm.setOnTouchListener(this.hxt);
        this.mListView.setOnTouchListener(this.hxt);
        this.mRootView.setOnTouchListener(this.hxt);
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
        this.bRw = false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.ala.liveroom.challenge.panel.g
    public boolean onBackKeyDown() {
        this.hwT.cdH();
        return true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.ala.liveroom.challenge.panel.g
    public int cdt() {
        return this.mContext.getResources().getDimensionPixelSize(a.d.sdk_ds560) * 2;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.ala.liveroom.challenge.panel.g
    public void cdL() {
        super.cdL();
        BdUtilHelper.hideSoftKeyPad(this.mContext, this.hxm);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.ala.liveroom.challenge.panel.g
    public void hide() {
        super.hide();
        if (this.hxp != null) {
            this.mListView.setSelection(0);
            this.mListView.removeFooterView(this.bRf);
            this.hxp.cdO();
        }
        this.hxm.setText("");
        WZ();
    }

    public void j(com.baidu.live.challenge.d dVar) {
        if (this.hxp != null) {
            this.hxp.i(dVar);
        }
    }

    public void cdA() {
        if (this.hxp != null) {
            this.hxp.notifyDataSetChanged();
        }
    }

    public void a(int i, CommonEmptyView.ImgType imgType) {
        if (this.mContext != null) {
            if (this.bwJ == null) {
                this.bwJ = new CommonEmptyView(this.mContext);
                if (this.mRootView instanceof RelativeLayout) {
                    this.bwJ.addToParent((RelativeLayout) this.mRootView);
                } else if (this.mRootView instanceof FrameLayout) {
                    this.bwJ.addToParent((FrameLayout) this.mRootView);
                }
            }
            this.bwJ.setTitle(i);
            this.bwJ.setup(imgType, CommonEmptyView.StyleType.DARK);
            if (imgType == CommonEmptyView.ImgType.NO_NET || imgType == CommonEmptyView.ImgType.SERVER_ERROR) {
                this.bwJ.setRefreshButton(a.h.ala_click_retry, this.bRl);
            }
            this.bwJ.setVisibility(0);
        }
    }

    public void WZ() {
        if (this.bwJ != null) {
            this.bwJ.setVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void b(com.baidu.live.challenge.b bVar, List<com.baidu.live.challenge.d> list) {
        this.bRw = false;
        if (bVar != null && this.mRootView.getParent() != null) {
            if (ListUtils.isEmpty(list) && bVar.pn == 1) {
                this.mListView.setVisibility(8);
                if (TextUtils.isEmpty(this.hxq)) {
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
            WZ();
            if (bVar.pn == 1) {
                this.hxp.setDatas(list);
            } else {
                this.hxp.cE(list);
            }
            this.pn = bVar.pn + 1;
            this.mHasMore = bVar.hasMore;
            if (bVar.hasMore) {
                WX();
            } else {
                WY();
            }
        }
    }

    private void WX() {
        this.bRf.setText(this.mContext.getString(a.h.sdk_loading_text_with_ellipsis));
        this.mListView.removeFooterView(this.bRf);
        this.mListView.addFooterView(this.bRf);
    }

    private void WY() {
        this.bRf.setText(this.mContext.getString(a.h.sdk_list_no_more));
        this.mListView.removeFooterView(this.bRf);
        this.mListView.addFooterView(this.bRf);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void bn(int i, String str) {
        this.bRw = false;
        BdUtilHelper.showToast(this.mContext, str);
        if (this.hxp.getCount() <= 0 || this.pn == 1) {
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
