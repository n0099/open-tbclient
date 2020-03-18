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
    private EditText eWA;
    private View eWB;
    private ImageView eWC;
    private g eWD;
    private TextView eWE;
    private String eWF;
    private TextWatcher eWG;
    private View.OnFocusChangeListener eWH;
    private View.OnTouchListener eWI;
    public a eWv;
    private CommonEmptyView ewA;
    private View.OnClickListener eyG;
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
        this.eyG = new View.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.challenge.panel.h.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                h.this.pn = 1;
                if (TextUtils.isEmpty(h.this.eWF)) {
                    h.this.eWg.bo(h.this.pn, 30);
                } else {
                    h.this.eWg.i(h.this.pn, 10, h.this.eWF);
                }
            }
        };
        this.eWv = new a() { // from class: com.baidu.tieba.ala.liveroom.challenge.panel.h.3
            @Override // com.baidu.tieba.ala.liveroom.challenge.panel.h.a
            public void g(com.baidu.live.challenge.d dVar) {
                if (dVar != null) {
                    h.this.eWg.t(dVar.userId);
                }
            }
        };
        this.mClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.challenge.panel.h.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (view != h.this.eWC) {
                    if (view == h.this.eWB) {
                        h.this.eWA.setText("");
                        return;
                    }
                    return;
                }
                h.this.eWg.bkU();
            }
        };
        this.eWG = new TextWatcher() { // from class: com.baidu.tieba.ala.liveroom.challenge.panel.h.5
            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                h.this.pn = 1;
                if (charSequence == null || charSequence.length() == 0) {
                    h.this.eWF = "";
                    h.this.eWB.setVisibility(8);
                    h.this.eWg.bo(h.this.pn, 30);
                    return;
                }
                h.this.eWF = charSequence.toString();
                h.this.eWB.setVisibility(0);
                h.this.eWg.i(h.this.pn, 10, h.this.eWF);
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
            }
        };
        this.eWH = new View.OnFocusChangeListener() { // from class: com.baidu.tieba.ala.liveroom.challenge.panel.h.6
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
        this.eWI = new View.OnTouchListener() { // from class: com.baidu.tieba.ala.liveroom.challenge.panel.h.8
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                BdUtilHelper.hideSoftKeyPad(h.this.mContext, view);
                return false;
            }
        };
        this.eWC = (ImageView) this.mRootView.findViewById(a.g.ala_challenge_user_choose_back);
        this.eWC.setOnClickListener(this.mClickListener);
        this.mListView = (BdListView) this.mRootView.findViewById(a.g.ala_challenge_user_list);
        this.eWD = new g(context);
        this.eWD.a(this.eWv);
        this.mListView.setAdapter((ListAdapter) this.eWD);
        this.mListView.setOnSrollToBottomListener(new BdListView.OnScrollToBottomListener() { // from class: com.baidu.tieba.ala.liveroom.challenge.panel.h.2
            @Override // com.baidu.live.adp.widget.listview.BdListView.OnScrollToBottomListener
            public void onScrollToBottom() {
                if (h.this.mHasMore) {
                    if (TextUtils.isEmpty(h.this.eWF)) {
                        h.this.eWg.bo(h.this.pn, 30);
                    } else {
                        h.this.eWg.i(h.this.pn, 10, h.this.eWF);
                    }
                }
            }
        });
        this.eWE = new TextView(this.mContext);
        this.eWE.setTextColor(this.mContext.getResources().getColor(a.d.sdk_white_alpha50));
        this.eWE.setTextSize(0, this.mContext.getResources().getDimensionPixelSize(a.e.sdk_fontsize24));
        this.eWE.setPadding(0, this.mContext.getResources().getDimensionPixelSize(a.e.sdk_ds28), 0, this.mContext.getResources().getDimensionPixelSize(a.e.sdk_ds28));
        this.eWE.setGravity(17);
        this.eWB = this.mRootView.findViewById(a.g.delete_search_pk_textview);
        this.eWB.setOnClickListener(this.mClickListener);
        this.eWA = (EditText) this.mRootView.findViewById(a.g.search_pk_edittext);
        this.eWA.addTextChangedListener(this.eWG);
        this.eWA.setOnFocusChangeListener(this.eWH);
        this.eWA.setOnEditorActionListener(this.mOnEditorActionListener);
        this.eWA.setOnTouchListener(this.eWI);
        this.mListView.setOnTouchListener(this.eWI);
        this.mRootView.setOnTouchListener(this.eWI);
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
        this.eWg.bkU();
        return true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.ala.liveroom.challenge.panel.e
    public int bkL() {
        return this.mContext.getResources().getDimensionPixelSize(a.e.sdk_ds560) * 2;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.ala.liveroom.challenge.panel.e
    public void bkX() {
        super.bkX();
        BdUtilHelper.hideSoftKeyPad(this.mContext, this.eWA);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.ala.liveroom.challenge.panel.e
    public void hide() {
        super.hide();
        if (this.eWD != null) {
            this.mListView.setSelection(0);
            this.mListView.removeFooterView(this.eWE);
            this.eWD.bla();
        }
        this.eWA.setText("");
        bcC();
    }

    public void f(com.baidu.live.challenge.d dVar) {
        if (this.eWD != null) {
            this.eWD.e(dVar);
        }
    }

    public void blb() {
        if (this.eWD != null) {
            this.eWD.notifyDataSetChanged();
        }
    }

    public void a(int i, CommonEmptyView.ImgType imgType) {
        if (this.mContext != null) {
            if (this.ewA == null) {
                this.ewA = new CommonEmptyView(this.mContext);
                if (this.mRootView instanceof RelativeLayout) {
                    this.ewA.addToParent((RelativeLayout) this.mRootView);
                } else if (this.mRootView instanceof FrameLayout) {
                    this.ewA.addToParent((FrameLayout) this.mRootView);
                }
            }
            this.ewA.setTitle(i);
            this.ewA.setup(imgType, CommonEmptyView.StyleType.DARK);
            if (imgType == CommonEmptyView.ImgType.NO_NET || imgType == CommonEmptyView.ImgType.SERVER_ERROR) {
                this.ewA.setRefreshButton(a.i.ala_click_retry, this.eyG);
            }
            this.ewA.setVisibility(0);
        }
    }

    public void bcC() {
        if (this.ewA != null) {
            this.ewA.setVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void b(com.baidu.live.challenge.b bVar, List<com.baidu.live.challenge.d> list) {
        if (bVar != null && this.mRootView.getParent() != null) {
            if (ListUtils.isEmpty(list) && bVar.pn == 1) {
                this.mListView.setVisibility(8);
                if (TextUtils.isEmpty(this.eWF)) {
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
            bcC();
            if (bVar.pn == 1) {
                this.eWD.setDatas(list);
            } else {
                this.eWD.bD(list);
            }
            this.pn = bVar.pn + 1;
            this.mHasMore = bVar.hasMore;
            if (bVar.hasMore) {
                bdx();
            } else {
                bdy();
            }
        }
    }

    private void bdx() {
        this.eWE.setText(this.mContext.getString(a.i.sdk_loading_text_with_ellipsis));
        this.mListView.removeFooterView(this.eWE);
        this.mListView.addFooterView(this.eWE);
    }

    private void bdy() {
        this.eWE.setText(this.mContext.getString(a.i.sdk_list_no_more));
        this.mListView.removeFooterView(this.eWE);
        this.mListView.addFooterView(this.eWE);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void au(int i, String str) {
        BdUtilHelper.showToast(this.mContext, str);
        if (this.eWD.getCount() <= 0 || this.pn == 1) {
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
