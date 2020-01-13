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
import com.baidu.live.r.a;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.live.tbadk.core.util.ListUtils;
import com.baidu.live.tbadk.widget.CommonEmptyView;
import java.util.List;
/* loaded from: classes2.dex */
public class h extends e {
    public a eRS;
    private EditText eRX;
    private View eRY;
    private ImageView eRZ;
    private g eSa;
    private TextView eSb;
    private String eSc;
    private TextWatcher eSd;
    private View.OnFocusChangeListener eSe;
    private View.OnTouchListener eSf;
    private CommonEmptyView erG;
    private View.OnClickListener etK;
    private View.OnClickListener mClickListener;
    private boolean mHasMore;
    private BdListView mListView;
    private TextView.OnEditorActionListener mOnEditorActionListener;
    private int pn;

    /* loaded from: classes2.dex */
    public interface a {
        void g(com.baidu.live.challenge.d dVar);
    }

    public h(Context context, k kVar) {
        super(context, kVar);
        this.pn = 1;
        this.etK = new View.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.challenge.panel.h.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                h.this.pn = 1;
                if (TextUtils.isEmpty(h.this.eSc)) {
                    h.this.eRD.bm(h.this.pn, 30);
                } else {
                    h.this.eRD.i(h.this.pn, 10, h.this.eSc);
                }
            }
        };
        this.eRS = new a() { // from class: com.baidu.tieba.ala.liveroom.challenge.panel.h.3
            @Override // com.baidu.tieba.ala.liveroom.challenge.panel.h.a
            public void g(com.baidu.live.challenge.d dVar) {
                if (dVar != null) {
                    h.this.eRD.s(dVar.userId);
                }
            }
        };
        this.mClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.challenge.panel.h.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (view != h.this.eRZ) {
                    if (view == h.this.eRY) {
                        h.this.eRX.setText("");
                        return;
                    }
                    return;
                }
                h.this.eRD.biX();
            }
        };
        this.eSd = new TextWatcher() { // from class: com.baidu.tieba.ala.liveroom.challenge.panel.h.5
            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                h.this.pn = 1;
                if (charSequence == null || charSequence.length() == 0) {
                    h.this.eSc = "";
                    h.this.eRY.setVisibility(8);
                    h.this.eRD.bm(h.this.pn, 30);
                    return;
                }
                h.this.eSc = charSequence.toString();
                h.this.eRY.setVisibility(0);
                h.this.eRD.i(h.this.pn, 10, h.this.eSc);
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
            }
        };
        this.eSe = new View.OnFocusChangeListener() { // from class: com.baidu.tieba.ala.liveroom.challenge.panel.h.6
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
        this.eSf = new View.OnTouchListener() { // from class: com.baidu.tieba.ala.liveroom.challenge.panel.h.8
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                BdUtilHelper.hideSoftKeyPad(h.this.mContext, view);
                return false;
            }
        };
        this.eRZ = (ImageView) this.mRootView.findViewById(a.g.ala_challenge_user_choose_back);
        this.eRZ.setOnClickListener(this.mClickListener);
        this.mListView = (BdListView) this.mRootView.findViewById(a.g.ala_challenge_user_list);
        this.eSa = new g(context);
        this.eSa.a(this.eRS);
        this.mListView.setAdapter((ListAdapter) this.eSa);
        this.mListView.setOnSrollToBottomListener(new BdListView.OnScrollToBottomListener() { // from class: com.baidu.tieba.ala.liveroom.challenge.panel.h.2
            @Override // com.baidu.live.adp.widget.listview.BdListView.OnScrollToBottomListener
            public void onScrollToBottom() {
                if (h.this.mHasMore) {
                    if (TextUtils.isEmpty(h.this.eSc)) {
                        h.this.eRD.bm(h.this.pn, 30);
                    } else {
                        h.this.eRD.i(h.this.pn, 10, h.this.eSc);
                    }
                }
            }
        });
        this.eSb = new TextView(this.mContext);
        this.eSb.setTextColor(this.mContext.getResources().getColor(a.d.sdk_white_alpha50));
        this.eSb.setTextSize(0, this.mContext.getResources().getDimensionPixelSize(a.e.sdk_fontsize24));
        this.eSb.setPadding(0, this.mContext.getResources().getDimensionPixelSize(a.e.sdk_ds28), 0, this.mContext.getResources().getDimensionPixelSize(a.e.sdk_ds28));
        this.eSb.setGravity(17);
        this.eRY = this.mRootView.findViewById(a.g.delete_search_pk_textview);
        this.eRY.setOnClickListener(this.mClickListener);
        this.eRX = (EditText) this.mRootView.findViewById(a.g.search_pk_edittext);
        this.eRX.addTextChangedListener(this.eSd);
        this.eRX.setOnFocusChangeListener(this.eSe);
        this.eRX.setOnEditorActionListener(this.mOnEditorActionListener);
        this.eRX.setOnTouchListener(this.eSf);
        this.mListView.setOnTouchListener(this.eSf);
        this.mRootView.setOnTouchListener(this.eSf);
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
        this.eRD.biX();
        return true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.ala.liveroom.challenge.panel.e
    public int biN() {
        return this.mContext.getResources().getDimensionPixelSize(a.e.sdk_ds560) * 2;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.ala.liveroom.challenge.panel.e
    public void bja() {
        super.bja();
        BdUtilHelper.hideSoftKeyPad(this.mContext, this.eRX);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.ala.liveroom.challenge.panel.e
    public void hide() {
        super.hide();
        if (this.eSa != null) {
            this.mListView.setSelection(0);
            this.mListView.removeFooterView(this.eSb);
            this.eSa.bjd();
        }
        this.eRX.setText("");
        baf();
    }

    public void f(com.baidu.live.challenge.d dVar) {
        if (this.eSa != null) {
            this.eSa.e(dVar);
        }
    }

    public void bje() {
        if (this.eSa != null) {
            this.eSa.notifyDataSetChanged();
        }
    }

    public void a(int i, CommonEmptyView.ImgType imgType) {
        if (this.mContext != null) {
            if (this.erG == null) {
                this.erG = new CommonEmptyView(this.mContext);
                if (this.mRootView instanceof RelativeLayout) {
                    this.erG.addToParent((RelativeLayout) this.mRootView);
                } else if (this.mRootView instanceof FrameLayout) {
                    this.erG.addToParent((FrameLayout) this.mRootView);
                }
            }
            this.erG.setTitle(i);
            this.erG.setup(imgType, CommonEmptyView.StyleType.DARK);
            if (imgType == CommonEmptyView.ImgType.NO_NET || imgType == CommonEmptyView.ImgType.SERVER_ERROR) {
                this.erG.setRefreshButton(a.i.ala_click_retry, this.etK);
            }
            this.erG.setVisibility(0);
        }
    }

    public void baf() {
        if (this.erG != null) {
            this.erG.setVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void b(com.baidu.live.challenge.b bVar, List<com.baidu.live.challenge.d> list) {
        if (bVar != null && this.mRootView.getParent() != null) {
            if (ListUtils.isEmpty(list) && bVar.pn == 1) {
                this.mListView.setVisibility(8);
                if (TextUtils.isEmpty(this.eSc)) {
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
            baf();
            if (bVar.pn == 1) {
                this.eSa.setDatas(list);
            } else {
                this.eSa.bD(list);
            }
            this.pn = bVar.pn + 1;
            this.mHasMore = bVar.hasMore;
            if (bVar.hasMore) {
                bba();
            } else {
                bbb();
            }
        }
    }

    private void bba() {
        this.eSb.setText(this.mContext.getString(a.i.sdk_loading_text_with_ellipsis));
        this.mListView.removeFooterView(this.eSb);
        this.mListView.addFooterView(this.eSb);
    }

    private void bbb() {
        this.eSb.setText(this.mContext.getString(a.i.sdk_list_no_more));
        this.mListView.removeFooterView(this.eSb);
        this.mListView.addFooterView(this.eSb);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void as(int i, String str) {
        BdUtilHelper.showToast(this.mContext, str);
        if (this.eSa.getCount() <= 0 || this.pn == 1) {
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
