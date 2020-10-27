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
    private boolean bEB;
    private TextView bEk;
    private View.OnClickListener bEq;
    private CommonEmptyView boq;
    public a gVY;
    private EditText gWd;
    private View gWe;
    private ImageView gWf;
    private i gWg;
    private String gWh;
    private TextWatcher gWi;
    private View.OnFocusChangeListener gWj;
    private View.OnTouchListener gWk;
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
        this.bEq = new View.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.challenge.panel.j.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                j.this.pn = 1;
                j.this.bEB = false;
                if (TextUtils.isEmpty(j.this.gWh)) {
                    j.this.gVK.bO(j.this.pn, 30);
                } else {
                    j.this.gVK.k(j.this.pn, 10, j.this.gWh);
                }
            }
        };
        this.gVY = new a() { // from class: com.baidu.tieba.ala.liveroom.challenge.panel.j.3
            @Override // com.baidu.tieba.ala.liveroom.challenge.panel.j.a
            public void f(com.baidu.live.challenge.d dVar) {
                if (dVar != null) {
                    j.this.gVK.X(dVar.userId);
                }
            }
        };
        this.mClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.challenge.panel.j.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (view != j.this.gWf) {
                    if (view == j.this.gWe) {
                        j.this.gWd.setText("");
                        return;
                    }
                    return;
                }
                j.this.gVK.bXP();
            }
        };
        this.gWi = new TextWatcher() { // from class: com.baidu.tieba.ala.liveroom.challenge.panel.j.5
            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                j.this.pn = 1;
                j.this.bEB = false;
                if (charSequence == null || charSequence.length() == 0) {
                    j.this.gWh = "";
                    j.this.gWe.setVisibility(8);
                    j.this.gVK.bO(j.this.pn, 30);
                    return;
                }
                j.this.gWh = charSequence.toString();
                j.this.gWe.setVisibility(0);
                j.this.gVK.k(j.this.pn, 10, j.this.gWh);
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
            }
        };
        this.gWj = new View.OnFocusChangeListener() { // from class: com.baidu.tieba.ala.liveroom.challenge.panel.j.6
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
        this.gWk = new View.OnTouchListener() { // from class: com.baidu.tieba.ala.liveroom.challenge.panel.j.8
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                BdUtilHelper.hideSoftKeyPad(j.this.mContext, view);
                return false;
            }
        };
        this.gWf = (ImageView) this.mRootView.findViewById(a.g.ala_challenge_user_choose_back);
        this.gWf.setOnClickListener(this.mClickListener);
        this.mListView = (BdListView) this.mRootView.findViewById(a.g.ala_challenge_user_list);
        this.gWg = new i(context);
        this.gWg.a(this.gVY);
        this.mListView.setAdapter((ListAdapter) this.gWg);
        this.mListView.setOnSrollToBottomListener(new BdListView.OnScrollToBottomListener() { // from class: com.baidu.tieba.ala.liveroom.challenge.panel.j.2
            @Override // com.baidu.live.adp.widget.listview.BdListView.OnScrollToBottomListener
            public void onScrollToBottom() {
                if (j.this.mHasMore && !j.this.bEB) {
                    j.this.bEB = true;
                    if (TextUtils.isEmpty(j.this.gWh)) {
                        j.this.gVK.bO(j.this.pn, 30);
                    } else {
                        j.this.gVK.k(j.this.pn, 10, j.this.gWh);
                    }
                }
            }
        });
        this.bEk = new TextView(this.mContext);
        this.bEk.setTextColor(this.mContext.getResources().getColor(a.d.sdk_white_alpha50));
        this.bEk.setTextSize(0, this.mContext.getResources().getDimensionPixelSize(a.e.sdk_fontsize24));
        this.bEk.setPadding(0, this.mContext.getResources().getDimensionPixelSize(a.e.sdk_ds28), 0, this.mContext.getResources().getDimensionPixelSize(a.e.sdk_ds28));
        this.bEk.setGravity(17);
        this.gWe = this.mRootView.findViewById(a.g.delete_search_pk_textview);
        this.gWe.setOnClickListener(this.mClickListener);
        this.gWd = (EditText) this.mRootView.findViewById(a.g.search_pk_edittext);
        this.gWd.addTextChangedListener(this.gWi);
        this.gWd.setOnFocusChangeListener(this.gWj);
        this.gWd.setOnEditorActionListener(this.mOnEditorActionListener);
        this.gWd.setOnTouchListener(this.gWk);
        this.mListView.setOnTouchListener(this.gWk);
        this.mRootView.setOnTouchListener(this.gWk);
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
        this.bEB = false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.ala.liveroom.challenge.panel.g
    public boolean onBackKeyDown() {
        this.gVK.bXP();
        return true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.ala.liveroom.challenge.panel.g
    public int bXB() {
        return this.mContext.getResources().getDimensionPixelSize(a.e.sdk_ds560) * 2;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.ala.liveroom.challenge.panel.g
    public void bXT() {
        super.bXT();
        BdUtilHelper.hideSoftKeyPad(this.mContext, this.gWd);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.ala.liveroom.challenge.panel.g
    public void hide() {
        super.hide();
        if (this.gWg != null) {
            this.mListView.setSelection(0);
            this.mListView.removeFooterView(this.bEk);
            this.gWg.bXW();
        }
        this.gWd.setText("");
        TK();
    }

    public void j(com.baidu.live.challenge.d dVar) {
        if (this.gWg != null) {
            this.gWg.i(dVar);
        }
    }

    public void bXI() {
        if (this.gWg != null) {
            this.gWg.notifyDataSetChanged();
        }
    }

    public void a(int i, CommonEmptyView.ImgType imgType) {
        if (this.mContext != null) {
            if (this.boq == null) {
                this.boq = new CommonEmptyView(this.mContext);
                if (this.mRootView instanceof RelativeLayout) {
                    this.boq.addToParent((RelativeLayout) this.mRootView);
                } else if (this.mRootView instanceof FrameLayout) {
                    this.boq.addToParent((FrameLayout) this.mRootView);
                }
            }
            this.boq.setTitle(i);
            this.boq.setup(imgType, CommonEmptyView.StyleType.DARK);
            if (imgType == CommonEmptyView.ImgType.NO_NET || imgType == CommonEmptyView.ImgType.SERVER_ERROR) {
                this.boq.setRefreshButton(a.i.ala_click_retry, this.bEq);
            }
            this.boq.setVisibility(0);
        }
    }

    public void TK() {
        if (this.boq != null) {
            this.boq.setVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void b(com.baidu.live.challenge.b bVar, List<com.baidu.live.challenge.d> list) {
        this.bEB = false;
        if (bVar != null && this.mRootView.getParent() != null) {
            if (ListUtils.isEmpty(list) && bVar.pn == 1) {
                this.mListView.setVisibility(8);
                if (TextUtils.isEmpty(this.gWh)) {
                    a(a.i.ala_challenge_empty_challenger, CommonEmptyView.ImgType.NO_DATA);
                    return;
                } else if (TbadkCoreApplication.getInst().isQuanmin() || TbadkCoreApplication.getInst().isYinbo()) {
                    a(a.i.ala_challenge_search_empty, CommonEmptyView.ImgType.NO_RANK_LIST);
                    return;
                } else {
                    a(a.i.ala_challenge_search_empty, CommonEmptyView.ImgType.NO_DATA);
                    return;
                }
            }
            this.mListView.setVisibility(0);
            TK();
            if (bVar.pn == 1) {
                this.gWg.setDatas(list);
            } else {
                this.gWg.cq(list);
            }
            this.pn = bVar.pn + 1;
            this.mHasMore = bVar.hasMore;
            if (bVar.hasMore) {
                TI();
            } else {
                TJ();
            }
        }
    }

    private void TI() {
        this.bEk.setText(this.mContext.getString(a.i.sdk_loading_text_with_ellipsis));
        this.mListView.removeFooterView(this.bEk);
        this.mListView.addFooterView(this.bEk);
    }

    private void TJ() {
        this.bEk.setText(this.mContext.getString(a.i.sdk_list_no_more));
        this.mListView.removeFooterView(this.bEk);
        this.mListView.addFooterView(this.bEk);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void bd(int i, String str) {
        this.bEB = false;
        BdUtilHelper.showToast(this.mContext, str);
        if (this.gWg.getCount() <= 0 || this.pn == 1) {
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
