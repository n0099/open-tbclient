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
    public a fAJ;
    private EditText fAO;
    private View fAP;
    private ImageView fAQ;
    private g fAR;
    private TextView fAS;
    private String fAT;
    private TextWatcher fAU;
    private View.OnFocusChangeListener fAV;
    private View.OnTouchListener fAW;
    private CommonEmptyView faB;
    private View.OnClickListener fda;
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
        this.fda = new View.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.challenge.panel.h.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                h.this.pn = 1;
                if (TextUtils.isEmpty(h.this.fAT)) {
                    h.this.fAu.bt(h.this.pn, 30);
                } else {
                    h.this.fAu.i(h.this.pn, 10, h.this.fAT);
                }
            }
        };
        this.fAJ = new a() { // from class: com.baidu.tieba.ala.liveroom.challenge.panel.h.3
            @Override // com.baidu.tieba.ala.liveroom.challenge.panel.h.a
            public void g(com.baidu.live.challenge.d dVar) {
                if (dVar != null) {
                    h.this.fAu.R(dVar.userId);
                }
            }
        };
        this.mClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.challenge.panel.h.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (view != h.this.fAQ) {
                    if (view == h.this.fAP) {
                        h.this.fAO.setText("");
                        return;
                    }
                    return;
                }
                h.this.fAu.bun();
            }
        };
        this.fAU = new TextWatcher() { // from class: com.baidu.tieba.ala.liveroom.challenge.panel.h.5
            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                h.this.pn = 1;
                if (charSequence == null || charSequence.length() == 0) {
                    h.this.fAT = "";
                    h.this.fAP.setVisibility(8);
                    h.this.fAu.bt(h.this.pn, 30);
                    return;
                }
                h.this.fAT = charSequence.toString();
                h.this.fAP.setVisibility(0);
                h.this.fAu.i(h.this.pn, 10, h.this.fAT);
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
            }
        };
        this.fAV = new View.OnFocusChangeListener() { // from class: com.baidu.tieba.ala.liveroom.challenge.panel.h.6
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
        this.fAW = new View.OnTouchListener() { // from class: com.baidu.tieba.ala.liveroom.challenge.panel.h.8
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                BdUtilHelper.hideSoftKeyPad(h.this.mContext, view);
                return false;
            }
        };
        this.fAQ = (ImageView) this.mRootView.findViewById(a.g.ala_challenge_user_choose_back);
        this.fAQ.setOnClickListener(this.mClickListener);
        this.mListView = (BdListView) this.mRootView.findViewById(a.g.ala_challenge_user_list);
        this.fAR = new g(context);
        this.fAR.a(this.fAJ);
        this.mListView.setAdapter((ListAdapter) this.fAR);
        this.mListView.setOnSrollToBottomListener(new BdListView.OnScrollToBottomListener() { // from class: com.baidu.tieba.ala.liveroom.challenge.panel.h.2
            @Override // com.baidu.live.adp.widget.listview.BdListView.OnScrollToBottomListener
            public void onScrollToBottom() {
                if (h.this.mHasMore) {
                    if (TextUtils.isEmpty(h.this.fAT)) {
                        h.this.fAu.bt(h.this.pn, 30);
                    } else {
                        h.this.fAu.i(h.this.pn, 10, h.this.fAT);
                    }
                }
            }
        });
        this.fAS = new TextView(this.mContext);
        this.fAS.setTextColor(this.mContext.getResources().getColor(a.d.sdk_white_alpha50));
        this.fAS.setTextSize(0, this.mContext.getResources().getDimensionPixelSize(a.e.sdk_fontsize24));
        this.fAS.setPadding(0, this.mContext.getResources().getDimensionPixelSize(a.e.sdk_ds28), 0, this.mContext.getResources().getDimensionPixelSize(a.e.sdk_ds28));
        this.fAS.setGravity(17);
        this.fAP = this.mRootView.findViewById(a.g.delete_search_pk_textview);
        this.fAP.setOnClickListener(this.mClickListener);
        this.fAO = (EditText) this.mRootView.findViewById(a.g.search_pk_edittext);
        this.fAO.addTextChangedListener(this.fAU);
        this.fAO.setOnFocusChangeListener(this.fAV);
        this.fAO.setOnEditorActionListener(this.mOnEditorActionListener);
        this.fAO.setOnTouchListener(this.fAW);
        this.mListView.setOnTouchListener(this.fAW);
        this.mRootView.setOnTouchListener(this.fAW);
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
        this.fAu.bun();
        return true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.ala.liveroom.challenge.panel.e
    public int bue() {
        return this.mContext.getResources().getDimensionPixelSize(a.e.sdk_ds560) * 2;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.ala.liveroom.challenge.panel.e
    public void buq() {
        super.buq();
        BdUtilHelper.hideSoftKeyPad(this.mContext, this.fAO);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.ala.liveroom.challenge.panel.e
    public void hide() {
        super.hide();
        if (this.fAR != null) {
            this.mListView.setSelection(0);
            this.mListView.removeFooterView(this.fAS);
            this.fAR.but();
        }
        this.fAO.setText("");
        blt();
    }

    public void f(com.baidu.live.challenge.d dVar) {
        if (this.fAR != null) {
            this.fAR.e(dVar);
        }
    }

    public void buu() {
        if (this.fAR != null) {
            this.fAR.notifyDataSetChanged();
        }
    }

    public void a(int i, CommonEmptyView.ImgType imgType) {
        if (this.mContext != null) {
            if (this.faB == null) {
                this.faB = new CommonEmptyView(this.mContext);
                if (this.mRootView instanceof RelativeLayout) {
                    this.faB.addToParent((RelativeLayout) this.mRootView);
                } else if (this.mRootView instanceof FrameLayout) {
                    this.faB.addToParent((FrameLayout) this.mRootView);
                }
            }
            this.faB.setTitle(i);
            this.faB.setup(imgType, CommonEmptyView.StyleType.DARK);
            if (imgType == CommonEmptyView.ImgType.NO_NET || imgType == CommonEmptyView.ImgType.SERVER_ERROR) {
                this.faB.setRefreshButton(a.i.ala_click_retry, this.fda);
            }
            this.faB.setVisibility(0);
        }
    }

    public void blt() {
        if (this.faB != null) {
            this.faB.setVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void b(com.baidu.live.challenge.b bVar, List<com.baidu.live.challenge.d> list) {
        if (bVar != null && this.mRootView.getParent() != null) {
            if (ListUtils.isEmpty(list) && bVar.pn == 1) {
                this.mListView.setVisibility(8);
                if (TextUtils.isEmpty(this.fAT)) {
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
            blt();
            if (bVar.pn == 1) {
                this.fAR.setDatas(list);
            } else {
                this.fAR.bM(list);
            }
            this.pn = bVar.pn + 1;
            this.mHasMore = bVar.hasMore;
            if (bVar.hasMore) {
                bmo();
            } else {
                bmp();
            }
        }
    }

    private void bmo() {
        this.fAS.setText(this.mContext.getString(a.i.sdk_loading_text_with_ellipsis));
        this.mListView.removeFooterView(this.fAS);
        this.mListView.addFooterView(this.fAS);
    }

    private void bmp() {
        this.fAS.setText(this.mContext.getString(a.i.sdk_list_no_more));
        this.mListView.removeFooterView(this.fAS);
        this.mListView.addFooterView(this.fAS);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void aJ(int i, String str) {
        BdUtilHelper.showToast(this.mContext, str);
        if (this.fAR.getCount() <= 0 || this.pn == 1) {
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
