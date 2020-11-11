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
    private TextView bJR;
    private View.OnClickListener bJX;
    private boolean bKi;
    private CommonEmptyView bpJ;
    public a hcc;
    private EditText hch;
    private View hci;
    private ImageView hcj;
    private i hck;
    private String hcl;
    private TextWatcher hcm;
    private View.OnFocusChangeListener hcn;
    private View.OnTouchListener hco;
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
        this.bJX = new View.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.challenge.panel.j.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                j.this.pn = 1;
                j.this.bKi = false;
                if (TextUtils.isEmpty(j.this.hcl)) {
                    j.this.hbO.bQ(j.this.pn, 30);
                } else {
                    j.this.hbO.k(j.this.pn, 10, j.this.hcl);
                }
            }
        };
        this.hcc = new a() { // from class: com.baidu.tieba.ala.liveroom.challenge.panel.j.3
            @Override // com.baidu.tieba.ala.liveroom.challenge.panel.j.a
            public void f(com.baidu.live.challenge.d dVar) {
                if (dVar != null) {
                    j.this.hbO.aj(dVar.userId);
                }
            }
        };
        this.mClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.challenge.panel.j.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (view != j.this.hcj) {
                    if (view == j.this.hci) {
                        j.this.hch.setText("");
                        return;
                    }
                    return;
                }
                j.this.hbO.car();
            }
        };
        this.hcm = new TextWatcher() { // from class: com.baidu.tieba.ala.liveroom.challenge.panel.j.5
            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                j.this.pn = 1;
                j.this.bKi = false;
                if (charSequence == null || charSequence.length() == 0) {
                    j.this.hcl = "";
                    j.this.hci.setVisibility(8);
                    j.this.hbO.bQ(j.this.pn, 30);
                    return;
                }
                j.this.hcl = charSequence.toString();
                j.this.hci.setVisibility(0);
                j.this.hbO.k(j.this.pn, 10, j.this.hcl);
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
            }
        };
        this.hcn = new View.OnFocusChangeListener() { // from class: com.baidu.tieba.ala.liveroom.challenge.panel.j.6
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
        this.hco = new View.OnTouchListener() { // from class: com.baidu.tieba.ala.liveroom.challenge.panel.j.8
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                BdUtilHelper.hideSoftKeyPad(j.this.mContext, view);
                return false;
            }
        };
        this.hcj = (ImageView) this.mRootView.findViewById(a.f.ala_challenge_user_choose_back);
        this.hcj.setOnClickListener(this.mClickListener);
        this.mListView = (BdListView) this.mRootView.findViewById(a.f.ala_challenge_user_list);
        this.hck = new i(context);
        this.hck.a(this.hcc);
        this.mListView.setAdapter((ListAdapter) this.hck);
        this.mListView.setOnSrollToBottomListener(new BdListView.OnScrollToBottomListener() { // from class: com.baidu.tieba.ala.liveroom.challenge.panel.j.2
            @Override // com.baidu.live.adp.widget.listview.BdListView.OnScrollToBottomListener
            public void onScrollToBottom() {
                if (j.this.mHasMore && !j.this.bKi) {
                    j.this.bKi = true;
                    if (TextUtils.isEmpty(j.this.hcl)) {
                        j.this.hbO.bQ(j.this.pn, 30);
                    } else {
                        j.this.hbO.k(j.this.pn, 10, j.this.hcl);
                    }
                }
            }
        });
        this.bJR = new TextView(this.mContext);
        this.bJR.setTextColor(this.mContext.getResources().getColor(a.c.sdk_white_alpha50));
        this.bJR.setTextSize(0, this.mContext.getResources().getDimensionPixelSize(a.d.sdk_fontsize24));
        this.bJR.setPadding(0, this.mContext.getResources().getDimensionPixelSize(a.d.sdk_ds28), 0, this.mContext.getResources().getDimensionPixelSize(a.d.sdk_ds28));
        this.bJR.setGravity(17);
        this.hci = this.mRootView.findViewById(a.f.delete_search_pk_textview);
        this.hci.setOnClickListener(this.mClickListener);
        this.hch = (EditText) this.mRootView.findViewById(a.f.search_pk_edittext);
        this.hch.addTextChangedListener(this.hcm);
        this.hch.setOnFocusChangeListener(this.hcn);
        this.hch.setOnEditorActionListener(this.mOnEditorActionListener);
        this.hch.setOnTouchListener(this.hco);
        this.mListView.setOnTouchListener(this.hco);
        this.mRootView.setOnTouchListener(this.hco);
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
        this.bKi = false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.ala.liveroom.challenge.panel.g
    public boolean onBackKeyDown() {
        this.hbO.car();
        return true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.ala.liveroom.challenge.panel.g
    public int cad() {
        return this.mContext.getResources().getDimensionPixelSize(a.d.sdk_ds560) * 2;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.ala.liveroom.challenge.panel.g
    public void cav() {
        super.cav();
        BdUtilHelper.hideSoftKeyPad(this.mContext, this.hch);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.ala.liveroom.challenge.panel.g
    public void hide() {
        super.hide();
        if (this.hck != null) {
            this.mListView.setSelection(0);
            this.mListView.removeFooterView(this.bJR);
            this.hck.cay();
        }
        this.hch.setText("");
        Wk();
    }

    public void j(com.baidu.live.challenge.d dVar) {
        if (this.hck != null) {
            this.hck.i(dVar);
        }
    }

    public void cak() {
        if (this.hck != null) {
            this.hck.notifyDataSetChanged();
        }
    }

    public void a(int i, CommonEmptyView.ImgType imgType) {
        if (this.mContext != null) {
            if (this.bpJ == null) {
                this.bpJ = new CommonEmptyView(this.mContext);
                if (this.mRootView instanceof RelativeLayout) {
                    this.bpJ.addToParent((RelativeLayout) this.mRootView);
                } else if (this.mRootView instanceof FrameLayout) {
                    this.bpJ.addToParent((FrameLayout) this.mRootView);
                }
            }
            this.bpJ.setTitle(i);
            this.bpJ.setup(imgType, CommonEmptyView.StyleType.DARK);
            if (imgType == CommonEmptyView.ImgType.NO_NET || imgType == CommonEmptyView.ImgType.SERVER_ERROR) {
                this.bpJ.setRefreshButton(a.h.ala_click_retry, this.bJX);
            }
            this.bpJ.setVisibility(0);
        }
    }

    public void Wk() {
        if (this.bpJ != null) {
            this.bpJ.setVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void b(com.baidu.live.challenge.b bVar, List<com.baidu.live.challenge.d> list) {
        this.bKi = false;
        if (bVar != null && this.mRootView.getParent() != null) {
            if (ListUtils.isEmpty(list) && bVar.pn == 1) {
                this.mListView.setVisibility(8);
                if (TextUtils.isEmpty(this.hcl)) {
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
            Wk();
            if (bVar.pn == 1) {
                this.hck.setDatas(list);
            } else {
                this.hck.cy(list);
            }
            this.pn = bVar.pn + 1;
            this.mHasMore = bVar.hasMore;
            if (bVar.hasMore) {
                Wi();
            } else {
                Wj();
            }
        }
    }

    private void Wi() {
        this.bJR.setText(this.mContext.getString(a.h.sdk_loading_text_with_ellipsis));
        this.mListView.removeFooterView(this.bJR);
        this.mListView.addFooterView(this.bJR);
    }

    private void Wj() {
        this.bJR.setText(this.mContext.getString(a.h.sdk_list_no_more));
        this.mListView.removeFooterView(this.bJR);
        this.mListView.addFooterView(this.bJR);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void bh(int i, String str) {
        this.bKi = false;
        BdUtilHelper.showToast(this.mContext, str);
        if (this.hck.getCount() <= 0 || this.pn == 1) {
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
