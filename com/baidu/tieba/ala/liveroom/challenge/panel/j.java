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
    private CommonEmptyView bjf;
    private View.OnClickListener fVT;
    public a gvO;
    private EditText gvT;
    private View gvU;
    private ImageView gvV;
    private i gvW;
    private TextView gvX;
    private boolean gvY;
    private String gvZ;
    private TextWatcher gwa;
    private View.OnFocusChangeListener gwb;
    private View.OnTouchListener gwc;
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
        this.fVT = new View.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.challenge.panel.j.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                j.this.pn = 1;
                j.this.gvY = false;
                if (TextUtils.isEmpty(j.this.gvZ)) {
                    j.this.gvA.bM(j.this.pn, 30);
                } else {
                    j.this.gvA.i(j.this.pn, 10, j.this.gvZ);
                }
            }
        };
        this.gvO = new a() { // from class: com.baidu.tieba.ala.liveroom.challenge.panel.j.3
            @Override // com.baidu.tieba.ala.liveroom.challenge.panel.j.a
            public void f(com.baidu.live.challenge.d dVar) {
                if (dVar != null) {
                    j.this.gvA.V(dVar.userId);
                }
            }
        };
        this.mClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.challenge.panel.j.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (view != j.this.gvV) {
                    if (view == j.this.gvU) {
                        j.this.gvT.setText("");
                        return;
                    }
                    return;
                }
                j.this.gvA.bRw();
            }
        };
        this.gwa = new TextWatcher() { // from class: com.baidu.tieba.ala.liveroom.challenge.panel.j.5
            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                j.this.pn = 1;
                j.this.gvY = false;
                if (charSequence == null || charSequence.length() == 0) {
                    j.this.gvZ = "";
                    j.this.gvU.setVisibility(8);
                    j.this.gvA.bM(j.this.pn, 30);
                    return;
                }
                j.this.gvZ = charSequence.toString();
                j.this.gvU.setVisibility(0);
                j.this.gvA.i(j.this.pn, 10, j.this.gvZ);
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
            }
        };
        this.gwb = new View.OnFocusChangeListener() { // from class: com.baidu.tieba.ala.liveroom.challenge.panel.j.6
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
        this.gwc = new View.OnTouchListener() { // from class: com.baidu.tieba.ala.liveroom.challenge.panel.j.8
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                BdUtilHelper.hideSoftKeyPad(j.this.mContext, view);
                return false;
            }
        };
        this.gvV = (ImageView) this.mRootView.findViewById(a.g.ala_challenge_user_choose_back);
        this.gvV.setOnClickListener(this.mClickListener);
        this.mListView = (BdListView) this.mRootView.findViewById(a.g.ala_challenge_user_list);
        this.gvW = new i(context);
        this.gvW.a(this.gvO);
        this.mListView.setAdapter((ListAdapter) this.gvW);
        this.mListView.setOnSrollToBottomListener(new BdListView.OnScrollToBottomListener() { // from class: com.baidu.tieba.ala.liveroom.challenge.panel.j.2
            @Override // com.baidu.live.adp.widget.listview.BdListView.OnScrollToBottomListener
            public void onScrollToBottom() {
                if (j.this.mHasMore && !j.this.gvY) {
                    j.this.gvY = true;
                    if (TextUtils.isEmpty(j.this.gvZ)) {
                        j.this.gvA.bM(j.this.pn, 30);
                    } else {
                        j.this.gvA.i(j.this.pn, 10, j.this.gvZ);
                    }
                }
            }
        });
        this.gvX = new TextView(this.mContext);
        this.gvX.setTextColor(this.mContext.getResources().getColor(a.d.sdk_white_alpha50));
        this.gvX.setTextSize(0, this.mContext.getResources().getDimensionPixelSize(a.e.sdk_fontsize24));
        this.gvX.setPadding(0, this.mContext.getResources().getDimensionPixelSize(a.e.sdk_ds28), 0, this.mContext.getResources().getDimensionPixelSize(a.e.sdk_ds28));
        this.gvX.setGravity(17);
        this.gvU = this.mRootView.findViewById(a.g.delete_search_pk_textview);
        this.gvU.setOnClickListener(this.mClickListener);
        this.gvT = (EditText) this.mRootView.findViewById(a.g.search_pk_edittext);
        this.gvT.addTextChangedListener(this.gwa);
        this.gvT.setOnFocusChangeListener(this.gwb);
        this.gvT.setOnEditorActionListener(this.mOnEditorActionListener);
        this.gvT.setOnTouchListener(this.gwc);
        this.mListView.setOnTouchListener(this.gwc);
        this.mRootView.setOnTouchListener(this.gwc);
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
        this.gvY = false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.ala.liveroom.challenge.panel.g
    public boolean onBackKeyDown() {
        this.gvA.bRw();
        return true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.ala.liveroom.challenge.panel.g
    public int bRi() {
        return this.mContext.getResources().getDimensionPixelSize(a.e.sdk_ds560) * 2;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.ala.liveroom.challenge.panel.g
    public void bRA() {
        super.bRA();
        BdUtilHelper.hideSoftKeyPad(this.mContext, this.gvT);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.ala.liveroom.challenge.panel.g
    public void hide() {
        super.hide();
        if (this.gvW != null) {
            this.mListView.setSelection(0);
            this.mListView.removeFooterView(this.gvX);
            this.gvW.bRD();
        }
        this.gvT.setText("");
        bHn();
    }

    public void j(com.baidu.live.challenge.d dVar) {
        if (this.gvW != null) {
            this.gvW.i(dVar);
        }
    }

    public void bRp() {
        if (this.gvW != null) {
            this.gvW.notifyDataSetChanged();
        }
    }

    public void a(int i, CommonEmptyView.ImgType imgType) {
        if (this.mContext != null) {
            if (this.bjf == null) {
                this.bjf = new CommonEmptyView(this.mContext);
                if (this.mRootView instanceof RelativeLayout) {
                    this.bjf.addToParent((RelativeLayout) this.mRootView);
                } else if (this.mRootView instanceof FrameLayout) {
                    this.bjf.addToParent((FrameLayout) this.mRootView);
                }
            }
            this.bjf.setTitle(i);
            this.bjf.setup(imgType, CommonEmptyView.StyleType.DARK);
            if (imgType == CommonEmptyView.ImgType.NO_NET || imgType == CommonEmptyView.ImgType.SERVER_ERROR) {
                this.bjf.setRefreshButton(a.i.ala_click_retry, this.fVT);
            }
            this.bjf.setVisibility(0);
        }
    }

    public void bHn() {
        if (this.bjf != null) {
            this.bjf.setVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void b(com.baidu.live.challenge.b bVar, List<com.baidu.live.challenge.d> list) {
        this.gvY = false;
        if (bVar != null && this.mRootView.getParent() != null) {
            if (ListUtils.isEmpty(list) && bVar.pn == 1) {
                this.mListView.setVisibility(8);
                if (TextUtils.isEmpty(this.gvZ)) {
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
            bHn();
            if (bVar.pn == 1) {
                this.gvW.setDatas(list);
            } else {
                this.gvW.cd(list);
            }
            this.pn = bVar.pn + 1;
            this.mHasMore = bVar.hasMore;
            if (bVar.hasMore) {
                bIi();
            } else {
                bIj();
            }
        }
    }

    private void bIi() {
        this.gvX.setText(this.mContext.getString(a.i.sdk_loading_text_with_ellipsis));
        this.mListView.removeFooterView(this.gvX);
        this.mListView.addFooterView(this.gvX);
    }

    private void bIj() {
        this.gvX.setText(this.mContext.getString(a.i.sdk_list_no_more));
        this.mListView.removeFooterView(this.gvX);
        this.mListView.addFooterView(this.gvX);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void aR(int i, String str) {
        this.gvY = false;
        BdUtilHelper.showToast(this.mContext, str);
        if (this.gvW.getCount() <= 0 || this.pn == 1) {
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
