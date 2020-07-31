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
    private CommonEmptyView baQ;
    private View.OnClickListener fHo;
    public a ggg;
    private EditText ggl;
    private View ggm;
    private ImageView ggn;
    private i ggo;
    private TextView ggp;
    private String ggq;
    private TextWatcher ggr;
    private View.OnFocusChangeListener ggs;
    private View.OnTouchListener ggt;
    private View.OnClickListener mClickListener;
    private boolean mHasMore;
    private BdListView mListView;
    private TextView.OnEditorActionListener mOnEditorActionListener;
    private int pn;

    /* loaded from: classes4.dex */
    public interface a {
        void f(com.baidu.live.challenge.d dVar);
    }

    public j(Context context, m mVar) {
        super(context, mVar);
        this.pn = 1;
        this.fHo = new View.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.challenge.panel.j.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                j.this.pn = 1;
                if (TextUtils.isEmpty(j.this.ggq)) {
                    j.this.gfS.bE(j.this.pn, 30);
                } else {
                    j.this.gfS.i(j.this.pn, 10, j.this.ggq);
                }
            }
        };
        this.ggg = new a() { // from class: com.baidu.tieba.ala.liveroom.challenge.panel.j.3
            @Override // com.baidu.tieba.ala.liveroom.challenge.panel.j.a
            public void f(com.baidu.live.challenge.d dVar) {
                if (dVar != null) {
                    j.this.gfS.V(dVar.userId);
                }
            }
        };
        this.mClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.challenge.panel.j.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (view != j.this.ggn) {
                    if (view == j.this.ggm) {
                        j.this.ggl.setText("");
                        return;
                    }
                    return;
                }
                j.this.gfS.bGy();
            }
        };
        this.ggr = new TextWatcher() { // from class: com.baidu.tieba.ala.liveroom.challenge.panel.j.5
            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                j.this.pn = 1;
                if (charSequence == null || charSequence.length() == 0) {
                    j.this.ggq = "";
                    j.this.ggm.setVisibility(8);
                    j.this.gfS.bE(j.this.pn, 30);
                    return;
                }
                j.this.ggq = charSequence.toString();
                j.this.ggm.setVisibility(0);
                j.this.gfS.i(j.this.pn, 10, j.this.ggq);
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
            }
        };
        this.ggs = new View.OnFocusChangeListener() { // from class: com.baidu.tieba.ala.liveroom.challenge.panel.j.6
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
        this.ggt = new View.OnTouchListener() { // from class: com.baidu.tieba.ala.liveroom.challenge.panel.j.8
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                BdUtilHelper.hideSoftKeyPad(j.this.mContext, view);
                return false;
            }
        };
        this.ggn = (ImageView) this.mRootView.findViewById(a.g.ala_challenge_user_choose_back);
        this.ggn.setOnClickListener(this.mClickListener);
        this.mListView = (BdListView) this.mRootView.findViewById(a.g.ala_challenge_user_list);
        this.ggo = new i(context);
        this.ggo.a(this.ggg);
        this.mListView.setAdapter((ListAdapter) this.ggo);
        this.mListView.setOnSrollToBottomListener(new BdListView.OnScrollToBottomListener() { // from class: com.baidu.tieba.ala.liveroom.challenge.panel.j.2
            @Override // com.baidu.live.adp.widget.listview.BdListView.OnScrollToBottomListener
            public void onScrollToBottom() {
                if (j.this.mHasMore) {
                    if (TextUtils.isEmpty(j.this.ggq)) {
                        j.this.gfS.bE(j.this.pn, 30);
                    } else {
                        j.this.gfS.i(j.this.pn, 10, j.this.ggq);
                    }
                }
            }
        });
        this.ggp = new TextView(this.mContext);
        this.ggp.setTextColor(this.mContext.getResources().getColor(a.d.sdk_white_alpha50));
        this.ggp.setTextSize(0, this.mContext.getResources().getDimensionPixelSize(a.e.sdk_fontsize24));
        this.ggp.setPadding(0, this.mContext.getResources().getDimensionPixelSize(a.e.sdk_ds28), 0, this.mContext.getResources().getDimensionPixelSize(a.e.sdk_ds28));
        this.ggp.setGravity(17);
        this.ggm = this.mRootView.findViewById(a.g.delete_search_pk_textview);
        this.ggm.setOnClickListener(this.mClickListener);
        this.ggl = (EditText) this.mRootView.findViewById(a.g.search_pk_edittext);
        this.ggl.addTextChangedListener(this.ggr);
        this.ggl.setOnFocusChangeListener(this.ggs);
        this.ggl.setOnEditorActionListener(this.mOnEditorActionListener);
        this.ggl.setOnTouchListener(this.ggt);
        this.mListView.setOnTouchListener(this.ggt);
        this.mRootView.setOnTouchListener(this.ggt);
    }

    @Override // com.baidu.tieba.ala.liveroom.challenge.panel.g
    protected View createView() {
        return LayoutInflater.from(this.mContext).inflate(a.h.ala_challenge_user_choose_view, (ViewGroup) null);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.ala.liveroom.challenge.panel.g
    public void b(FrameLayout frameLayout, int i) {
        super.b(frameLayout, i);
        this.pn = 1;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.ala.liveroom.challenge.panel.g
    public boolean onBackKeyDown() {
        this.gfS.bGy();
        return true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.ala.liveroom.challenge.panel.g
    public int bGk() {
        return this.mContext.getResources().getDimensionPixelSize(a.e.sdk_ds560) * 2;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.ala.liveroom.challenge.panel.g
    public void bGB() {
        super.bGB();
        BdUtilHelper.hideSoftKeyPad(this.mContext, this.ggl);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.ala.liveroom.challenge.panel.g
    public void hide() {
        super.hide();
        if (this.ggo != null) {
            this.mListView.setSelection(0);
            this.mListView.removeFooterView(this.ggp);
            this.ggo.bGE();
        }
        this.ggl.setText("");
        bwX();
    }

    public void j(com.baidu.live.challenge.d dVar) {
        if (this.ggo != null) {
            this.ggo.i(dVar);
        }
    }

    public void bGr() {
        if (this.ggo != null) {
            this.ggo.notifyDataSetChanged();
        }
    }

    public void a(int i, CommonEmptyView.ImgType imgType) {
        if (this.mContext != null) {
            if (this.baQ == null) {
                this.baQ = new CommonEmptyView(this.mContext);
                if (this.mRootView instanceof RelativeLayout) {
                    this.baQ.addToParent((RelativeLayout) this.mRootView);
                } else if (this.mRootView instanceof FrameLayout) {
                    this.baQ.addToParent((FrameLayout) this.mRootView);
                }
            }
            this.baQ.setTitle(i);
            this.baQ.setup(imgType, CommonEmptyView.StyleType.DARK);
            if (imgType == CommonEmptyView.ImgType.NO_NET || imgType == CommonEmptyView.ImgType.SERVER_ERROR) {
                this.baQ.setRefreshButton(a.i.ala_click_retry, this.fHo);
            }
            this.baQ.setVisibility(0);
        }
    }

    public void bwX() {
        if (this.baQ != null) {
            this.baQ.setVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void b(com.baidu.live.challenge.b bVar, List<com.baidu.live.challenge.d> list) {
        if (bVar != null && this.mRootView.getParent() != null) {
            if (ListUtils.isEmpty(list) && bVar.pn == 1) {
                this.mListView.setVisibility(8);
                if (TextUtils.isEmpty(this.ggq)) {
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
            bwX();
            if (bVar.pn == 1) {
                this.ggo.setDatas(list);
            } else {
                this.ggo.bX(list);
            }
            this.pn = bVar.pn + 1;
            this.mHasMore = bVar.hasMore;
            if (bVar.hasMore) {
                bxS();
            } else {
                bxT();
            }
        }
    }

    private void bxS() {
        this.ggp.setText(this.mContext.getString(a.i.sdk_loading_text_with_ellipsis));
        this.mListView.removeFooterView(this.ggp);
        this.mListView.addFooterView(this.ggp);
    }

    private void bxT() {
        this.ggp.setText(this.mContext.getString(a.i.sdk_list_no_more));
        this.mListView.removeFooterView(this.ggp);
        this.mListView.addFooterView(this.ggp);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void aT(int i, String str) {
        BdUtilHelper.showToast(this.mContext, str);
        if (this.ggo.getCount() <= 0 || this.pn == 1) {
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
