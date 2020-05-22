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
    public a fOR;
    private EditText fOW;
    private View fOX;
    private ImageView fOY;
    private g fOZ;
    private TextView fPa;
    private String fPb;
    private TextWatcher fPc;
    private View.OnFocusChangeListener fPd;
    private View.OnTouchListener fPe;
    private View.OnClickListener fqI;
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
        this.fqI = new View.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.challenge.panel.h.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                h.this.pn = 1;
                if (TextUtils.isEmpty(h.this.fPb)) {
                    h.this.fOC.bx(h.this.pn, 30);
                } else {
                    h.this.fOC.i(h.this.pn, 10, h.this.fPb);
                }
            }
        };
        this.fOR = new a() { // from class: com.baidu.tieba.ala.liveroom.challenge.panel.h.3
            @Override // com.baidu.tieba.ala.liveroom.challenge.panel.h.a
            public void g(com.baidu.live.challenge.d dVar) {
                if (dVar != null) {
                    h.this.fOC.V(dVar.userId);
                }
            }
        };
        this.mClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.challenge.panel.h.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (view != h.this.fOY) {
                    if (view == h.this.fOX) {
                        h.this.fOW.setText("");
                        return;
                    }
                    return;
                }
                h.this.fOC.bAk();
            }
        };
        this.fPc = new TextWatcher() { // from class: com.baidu.tieba.ala.liveroom.challenge.panel.h.5
            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                h.this.pn = 1;
                if (charSequence == null || charSequence.length() == 0) {
                    h.this.fPb = "";
                    h.this.fOX.setVisibility(8);
                    h.this.fOC.bx(h.this.pn, 30);
                    return;
                }
                h.this.fPb = charSequence.toString();
                h.this.fOX.setVisibility(0);
                h.this.fOC.i(h.this.pn, 10, h.this.fPb);
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
            }
        };
        this.fPd = new View.OnFocusChangeListener() { // from class: com.baidu.tieba.ala.liveroom.challenge.panel.h.6
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
        this.fPe = new View.OnTouchListener() { // from class: com.baidu.tieba.ala.liveroom.challenge.panel.h.8
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                BdUtilHelper.hideSoftKeyPad(h.this.mContext, view);
                return false;
            }
        };
        this.fOY = (ImageView) this.mRootView.findViewById(a.g.ala_challenge_user_choose_back);
        this.fOY.setOnClickListener(this.mClickListener);
        this.mListView = (BdListView) this.mRootView.findViewById(a.g.ala_challenge_user_list);
        this.fOZ = new g(context);
        this.fOZ.a(this.fOR);
        this.mListView.setAdapter((ListAdapter) this.fOZ);
        this.mListView.setOnSrollToBottomListener(new BdListView.OnScrollToBottomListener() { // from class: com.baidu.tieba.ala.liveroom.challenge.panel.h.2
            @Override // com.baidu.live.adp.widget.listview.BdListView.OnScrollToBottomListener
            public void onScrollToBottom() {
                if (h.this.mHasMore) {
                    if (TextUtils.isEmpty(h.this.fPb)) {
                        h.this.fOC.bx(h.this.pn, 30);
                    } else {
                        h.this.fOC.i(h.this.pn, 10, h.this.fPb);
                    }
                }
            }
        });
        this.fPa = new TextView(this.mContext);
        this.fPa.setTextColor(this.mContext.getResources().getColor(a.d.sdk_white_alpha50));
        this.fPa.setTextSize(0, this.mContext.getResources().getDimensionPixelSize(a.e.sdk_fontsize24));
        this.fPa.setPadding(0, this.mContext.getResources().getDimensionPixelSize(a.e.sdk_ds28), 0, this.mContext.getResources().getDimensionPixelSize(a.e.sdk_ds28));
        this.fPa.setGravity(17);
        this.fOX = this.mRootView.findViewById(a.g.delete_search_pk_textview);
        this.fOX.setOnClickListener(this.mClickListener);
        this.fOW = (EditText) this.mRootView.findViewById(a.g.search_pk_edittext);
        this.fOW.addTextChangedListener(this.fPc);
        this.fOW.setOnFocusChangeListener(this.fPd);
        this.fOW.setOnEditorActionListener(this.mOnEditorActionListener);
        this.fOW.setOnTouchListener(this.fPe);
        this.mListView.setOnTouchListener(this.fPe);
        this.mRootView.setOnTouchListener(this.fPe);
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
        this.fOC.bAk();
        return true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.ala.liveroom.challenge.panel.e
    public int bAb() {
        return this.mContext.getResources().getDimensionPixelSize(a.e.sdk_ds560) * 2;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.ala.liveroom.challenge.panel.e
    public void bAn() {
        super.bAn();
        BdUtilHelper.hideSoftKeyPad(this.mContext, this.fOW);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.ala.liveroom.challenge.panel.e
    public void hide() {
        super.hide();
        if (this.fOZ != null) {
            this.mListView.setSelection(0);
            this.mListView.removeFooterView(this.fPa);
            this.fOZ.bAq();
        }
        this.fOW.setText("");
        bqO();
    }

    public void f(com.baidu.live.challenge.d dVar) {
        if (this.fOZ != null) {
            this.fOZ.e(dVar);
        }
    }

    public void bAr() {
        if (this.fOZ != null) {
            this.fOZ.notifyDataSetChanged();
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
                this.aYj.setRefreshButton(a.i.ala_click_retry, this.fqI);
            }
            this.aYj.setVisibility(0);
        }
    }

    public void bqO() {
        if (this.aYj != null) {
            this.aYj.setVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void b(com.baidu.live.challenge.b bVar, List<com.baidu.live.challenge.d> list) {
        if (bVar != null && this.mRootView.getParent() != null) {
            if (ListUtils.isEmpty(list) && bVar.pn == 1) {
                this.mListView.setVisibility(8);
                if (TextUtils.isEmpty(this.fPb)) {
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
            bqO();
            if (bVar.pn == 1) {
                this.fOZ.setDatas(list);
            } else {
                this.fOZ.bJ(list);
            }
            this.pn = bVar.pn + 1;
            this.mHasMore = bVar.hasMore;
            if (bVar.hasMore) {
                brK();
            } else {
                brL();
            }
        }
    }

    private void brK() {
        this.fPa.setText(this.mContext.getString(a.i.sdk_loading_text_with_ellipsis));
        this.mListView.removeFooterView(this.fPa);
        this.mListView.addFooterView(this.fPa);
    }

    private void brL() {
        this.fPa.setText(this.mContext.getString(a.i.sdk_list_no_more));
        this.mListView.removeFooterView(this.fPa);
        this.mListView.addFooterView(this.fPa);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void aO(int i, String str) {
        BdUtilHelper.showToast(this.mContext, str);
        if (this.fOZ.getCount() <= 0 || this.pn == 1) {
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
