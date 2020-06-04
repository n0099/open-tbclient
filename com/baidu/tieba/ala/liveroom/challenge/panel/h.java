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
    private CommonEmptyView aYj;
    public a fPc;
    private EditText fPh;
    private View fPi;
    private ImageView fPj;
    private g fPk;
    private TextView fPl;
    private String fPm;
    private TextWatcher fPn;
    private View.OnFocusChangeListener fPo;
    private View.OnTouchListener fPp;
    private View.OnClickListener fqT;
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
        this.fqT = new View.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.challenge.panel.h.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                h.this.pn = 1;
                if (TextUtils.isEmpty(h.this.fPm)) {
                    h.this.fON.bx(h.this.pn, 30);
                } else {
                    h.this.fON.i(h.this.pn, 10, h.this.fPm);
                }
            }
        };
        this.fPc = new a() { // from class: com.baidu.tieba.ala.liveroom.challenge.panel.h.3
            @Override // com.baidu.tieba.ala.liveroom.challenge.panel.h.a
            public void g(com.baidu.live.challenge.d dVar) {
                if (dVar != null) {
                    h.this.fON.V(dVar.userId);
                }
            }
        };
        this.mClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.challenge.panel.h.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (view != h.this.fPj) {
                    if (view == h.this.fPi) {
                        h.this.fPh.setText("");
                        return;
                    }
                    return;
                }
                h.this.fON.bAm();
            }
        };
        this.fPn = new TextWatcher() { // from class: com.baidu.tieba.ala.liveroom.challenge.panel.h.5
            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                h.this.pn = 1;
                if (charSequence == null || charSequence.length() == 0) {
                    h.this.fPm = "";
                    h.this.fPi.setVisibility(8);
                    h.this.fON.bx(h.this.pn, 30);
                    return;
                }
                h.this.fPm = charSequence.toString();
                h.this.fPi.setVisibility(0);
                h.this.fON.i(h.this.pn, 10, h.this.fPm);
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
            }
        };
        this.fPo = new View.OnFocusChangeListener() { // from class: com.baidu.tieba.ala.liveroom.challenge.panel.h.6
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
        this.fPp = new View.OnTouchListener() { // from class: com.baidu.tieba.ala.liveroom.challenge.panel.h.8
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                BdUtilHelper.hideSoftKeyPad(h.this.mContext, view);
                return false;
            }
        };
        this.fPj = (ImageView) this.mRootView.findViewById(a.g.ala_challenge_user_choose_back);
        this.fPj.setOnClickListener(this.mClickListener);
        this.mListView = (BdListView) this.mRootView.findViewById(a.g.ala_challenge_user_list);
        this.fPk = new g(context);
        this.fPk.a(this.fPc);
        this.mListView.setAdapter((ListAdapter) this.fPk);
        this.mListView.setOnSrollToBottomListener(new BdListView.OnScrollToBottomListener() { // from class: com.baidu.tieba.ala.liveroom.challenge.panel.h.2
            @Override // com.baidu.live.adp.widget.listview.BdListView.OnScrollToBottomListener
            public void onScrollToBottom() {
                if (h.this.mHasMore) {
                    if (TextUtils.isEmpty(h.this.fPm)) {
                        h.this.fON.bx(h.this.pn, 30);
                    } else {
                        h.this.fON.i(h.this.pn, 10, h.this.fPm);
                    }
                }
            }
        });
        this.fPl = new TextView(this.mContext);
        this.fPl.setTextColor(this.mContext.getResources().getColor(a.d.sdk_white_alpha50));
        this.fPl.setTextSize(0, this.mContext.getResources().getDimensionPixelSize(a.e.sdk_fontsize24));
        this.fPl.setPadding(0, this.mContext.getResources().getDimensionPixelSize(a.e.sdk_ds28), 0, this.mContext.getResources().getDimensionPixelSize(a.e.sdk_ds28));
        this.fPl.setGravity(17);
        this.fPi = this.mRootView.findViewById(a.g.delete_search_pk_textview);
        this.fPi.setOnClickListener(this.mClickListener);
        this.fPh = (EditText) this.mRootView.findViewById(a.g.search_pk_edittext);
        this.fPh.addTextChangedListener(this.fPn);
        this.fPh.setOnFocusChangeListener(this.fPo);
        this.fPh.setOnEditorActionListener(this.mOnEditorActionListener);
        this.fPh.setOnTouchListener(this.fPp);
        this.mListView.setOnTouchListener(this.fPp);
        this.mRootView.setOnTouchListener(this.fPp);
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
        this.fON.bAm();
        return true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.ala.liveroom.challenge.panel.e
    public int bAd() {
        return this.mContext.getResources().getDimensionPixelSize(a.e.sdk_ds560) * 2;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.ala.liveroom.challenge.panel.e
    public void bAp() {
        super.bAp();
        BdUtilHelper.hideSoftKeyPad(this.mContext, this.fPh);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.ala.liveroom.challenge.panel.e
    public void hide() {
        super.hide();
        if (this.fPk != null) {
            this.mListView.setSelection(0);
            this.mListView.removeFooterView(this.fPl);
            this.fPk.bAs();
        }
        this.fPh.setText("");
        bqQ();
    }

    public void f(com.baidu.live.challenge.d dVar) {
        if (this.fPk != null) {
            this.fPk.e(dVar);
        }
    }

    public void bAt() {
        if (this.fPk != null) {
            this.fPk.notifyDataSetChanged();
        }
    }

    public void a(int i, CommonEmptyView.ImgType imgType) {
        if (this.mContext != null) {
            if (this.aYj == null) {
                this.aYj = new CommonEmptyView(this.mContext);
                if (this.mRootView instanceof RelativeLayout) {
                    this.aYj.addToParent((RelativeLayout) this.mRootView);
                } else if (this.mRootView instanceof FrameLayout) {
                    this.aYj.addToParent((FrameLayout) this.mRootView);
                }
            }
            this.aYj.setTitle(i);
            this.aYj.setup(imgType, CommonEmptyView.StyleType.DARK);
            if (imgType == CommonEmptyView.ImgType.NO_NET || imgType == CommonEmptyView.ImgType.SERVER_ERROR) {
                this.aYj.setRefreshButton(a.i.ala_click_retry, this.fqT);
            }
            this.aYj.setVisibility(0);
        }
    }

    public void bqQ() {
        if (this.aYj != null) {
            this.aYj.setVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void b(com.baidu.live.challenge.b bVar, List<com.baidu.live.challenge.d> list) {
        if (bVar != null && this.mRootView.getParent() != null) {
            if (ListUtils.isEmpty(list) && bVar.pn == 1) {
                this.mListView.setVisibility(8);
                if (TextUtils.isEmpty(this.fPm)) {
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
            bqQ();
            if (bVar.pn == 1) {
                this.fPk.setDatas(list);
            } else {
                this.fPk.bJ(list);
            }
            this.pn = bVar.pn + 1;
            this.mHasMore = bVar.hasMore;
            if (bVar.hasMore) {
                brM();
            } else {
                brN();
            }
        }
    }

    private void brM() {
        this.fPl.setText(this.mContext.getString(a.i.sdk_loading_text_with_ellipsis));
        this.mListView.removeFooterView(this.fPl);
        this.mListView.addFooterView(this.fPl);
    }

    private void brN() {
        this.fPl.setText(this.mContext.getString(a.i.sdk_list_no_more));
        this.mListView.removeFooterView(this.fPl);
        this.mListView.addFooterView(this.fPl);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void aO(int i, String str) {
        BdUtilHelper.showToast(this.mContext, str);
        if (this.fPk.getCount() <= 0 || this.pn == 1) {
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
