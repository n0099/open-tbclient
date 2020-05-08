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
    public a fAO;
    private EditText fAT;
    private View fAU;
    private ImageView fAV;
    private g fAW;
    private TextView fAX;
    private String fAY;
    private TextWatcher fAZ;
    private View.OnFocusChangeListener fBa;
    private View.OnTouchListener fBb;
    private CommonEmptyView faG;
    private View.OnClickListener fdf;
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
        this.fdf = new View.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.challenge.panel.h.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                h.this.pn = 1;
                if (TextUtils.isEmpty(h.this.fAY)) {
                    h.this.fAz.bt(h.this.pn, 30);
                } else {
                    h.this.fAz.i(h.this.pn, 10, h.this.fAY);
                }
            }
        };
        this.fAO = new a() { // from class: com.baidu.tieba.ala.liveroom.challenge.panel.h.3
            @Override // com.baidu.tieba.ala.liveroom.challenge.panel.h.a
            public void g(com.baidu.live.challenge.d dVar) {
                if (dVar != null) {
                    h.this.fAz.R(dVar.userId);
                }
            }
        };
        this.mClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.challenge.panel.h.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (view != h.this.fAV) {
                    if (view == h.this.fAU) {
                        h.this.fAT.setText("");
                        return;
                    }
                    return;
                }
                h.this.fAz.bul();
            }
        };
        this.fAZ = new TextWatcher() { // from class: com.baidu.tieba.ala.liveroom.challenge.panel.h.5
            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                h.this.pn = 1;
                if (charSequence == null || charSequence.length() == 0) {
                    h.this.fAY = "";
                    h.this.fAU.setVisibility(8);
                    h.this.fAz.bt(h.this.pn, 30);
                    return;
                }
                h.this.fAY = charSequence.toString();
                h.this.fAU.setVisibility(0);
                h.this.fAz.i(h.this.pn, 10, h.this.fAY);
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
            }
        };
        this.fBa = new View.OnFocusChangeListener() { // from class: com.baidu.tieba.ala.liveroom.challenge.panel.h.6
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
        this.fBb = new View.OnTouchListener() { // from class: com.baidu.tieba.ala.liveroom.challenge.panel.h.8
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                BdUtilHelper.hideSoftKeyPad(h.this.mContext, view);
                return false;
            }
        };
        this.fAV = (ImageView) this.mRootView.findViewById(a.g.ala_challenge_user_choose_back);
        this.fAV.setOnClickListener(this.mClickListener);
        this.mListView = (BdListView) this.mRootView.findViewById(a.g.ala_challenge_user_list);
        this.fAW = new g(context);
        this.fAW.a(this.fAO);
        this.mListView.setAdapter((ListAdapter) this.fAW);
        this.mListView.setOnSrollToBottomListener(new BdListView.OnScrollToBottomListener() { // from class: com.baidu.tieba.ala.liveroom.challenge.panel.h.2
            @Override // com.baidu.live.adp.widget.listview.BdListView.OnScrollToBottomListener
            public void onScrollToBottom() {
                if (h.this.mHasMore) {
                    if (TextUtils.isEmpty(h.this.fAY)) {
                        h.this.fAz.bt(h.this.pn, 30);
                    } else {
                        h.this.fAz.i(h.this.pn, 10, h.this.fAY);
                    }
                }
            }
        });
        this.fAX = new TextView(this.mContext);
        this.fAX.setTextColor(this.mContext.getResources().getColor(a.d.sdk_white_alpha50));
        this.fAX.setTextSize(0, this.mContext.getResources().getDimensionPixelSize(a.e.sdk_fontsize24));
        this.fAX.setPadding(0, this.mContext.getResources().getDimensionPixelSize(a.e.sdk_ds28), 0, this.mContext.getResources().getDimensionPixelSize(a.e.sdk_ds28));
        this.fAX.setGravity(17);
        this.fAU = this.mRootView.findViewById(a.g.delete_search_pk_textview);
        this.fAU.setOnClickListener(this.mClickListener);
        this.fAT = (EditText) this.mRootView.findViewById(a.g.search_pk_edittext);
        this.fAT.addTextChangedListener(this.fAZ);
        this.fAT.setOnFocusChangeListener(this.fBa);
        this.fAT.setOnEditorActionListener(this.mOnEditorActionListener);
        this.fAT.setOnTouchListener(this.fBb);
        this.mListView.setOnTouchListener(this.fBb);
        this.mRootView.setOnTouchListener(this.fBb);
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
        this.fAz.bul();
        return true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.ala.liveroom.challenge.panel.e
    public int buc() {
        return this.mContext.getResources().getDimensionPixelSize(a.e.sdk_ds560) * 2;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.ala.liveroom.challenge.panel.e
    public void buo() {
        super.buo();
        BdUtilHelper.hideSoftKeyPad(this.mContext, this.fAT);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.ala.liveroom.challenge.panel.e
    public void hide() {
        super.hide();
        if (this.fAW != null) {
            this.mListView.setSelection(0);
            this.mListView.removeFooterView(this.fAX);
            this.fAW.bur();
        }
        this.fAT.setText("");
        blr();
    }

    public void f(com.baidu.live.challenge.d dVar) {
        if (this.fAW != null) {
            this.fAW.e(dVar);
        }
    }

    public void bus() {
        if (this.fAW != null) {
            this.fAW.notifyDataSetChanged();
        }
    }

    public void a(int i, CommonEmptyView.ImgType imgType) {
        if (this.mContext != null) {
            if (this.faG == null) {
                this.faG = new CommonEmptyView(this.mContext);
                if (this.mRootView instanceof RelativeLayout) {
                    this.faG.addToParent((RelativeLayout) this.mRootView);
                } else if (this.mRootView instanceof FrameLayout) {
                    this.faG.addToParent((FrameLayout) this.mRootView);
                }
            }
            this.faG.setTitle(i);
            this.faG.setup(imgType, CommonEmptyView.StyleType.DARK);
            if (imgType == CommonEmptyView.ImgType.NO_NET || imgType == CommonEmptyView.ImgType.SERVER_ERROR) {
                this.faG.setRefreshButton(a.i.ala_click_retry, this.fdf);
            }
            this.faG.setVisibility(0);
        }
    }

    public void blr() {
        if (this.faG != null) {
            this.faG.setVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void b(com.baidu.live.challenge.b bVar, List<com.baidu.live.challenge.d> list) {
        if (bVar != null && this.mRootView.getParent() != null) {
            if (ListUtils.isEmpty(list) && bVar.pn == 1) {
                this.mListView.setVisibility(8);
                if (TextUtils.isEmpty(this.fAY)) {
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
            blr();
            if (bVar.pn == 1) {
                this.fAW.setDatas(list);
            } else {
                this.fAW.bM(list);
            }
            this.pn = bVar.pn + 1;
            this.mHasMore = bVar.hasMore;
            if (bVar.hasMore) {
                bmm();
            } else {
                bmn();
            }
        }
    }

    private void bmm() {
        this.fAX.setText(this.mContext.getString(a.i.sdk_loading_text_with_ellipsis));
        this.mListView.removeFooterView(this.fAX);
        this.mListView.addFooterView(this.fAX);
    }

    private void bmn() {
        this.fAX.setText(this.mContext.getString(a.i.sdk_list_no_more));
        this.mListView.removeFooterView(this.fAX);
        this.mListView.addFooterView(this.fAX);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void aJ(int i, String str) {
        BdUtilHelper.showToast(this.mContext, str);
        if (this.fAW.getCount() <= 0 || this.pn == 1) {
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
