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
/* loaded from: classes10.dex */
public class j extends g {
    private TextView bSF;
    private View.OnClickListener bSL;
    private boolean bSW;
    private CommonEmptyView byj;
    public a hyQ;
    private EditText hyV;
    private View hyW;
    private ImageView hyX;
    private i hyY;
    private String hyZ;
    private TextWatcher hza;
    private View.OnFocusChangeListener hzb;
    private View.OnTouchListener hzc;
    private View.OnClickListener mClickListener;
    private boolean mHasMore;
    private BdListView mListView;
    private TextView.OnEditorActionListener mOnEditorActionListener;
    private int pn;

    /* loaded from: classes10.dex */
    public interface a {
        void f(com.baidu.live.challenge.d dVar);
    }

    public j(Context context, n nVar) {
        super(context, nVar);
        this.pn = 1;
        this.bSL = new View.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.challenge.panel.j.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                j.this.pn = 1;
                j.this.bSW = false;
                if (TextUtils.isEmpty(j.this.hyZ)) {
                    j.this.hyC.bR(j.this.pn, 30);
                } else {
                    j.this.hyC.j(j.this.pn, 10, j.this.hyZ);
                }
            }
        };
        this.hyQ = new a() { // from class: com.baidu.tieba.ala.liveroom.challenge.panel.j.3
            @Override // com.baidu.tieba.ala.liveroom.challenge.panel.j.a
            public void f(com.baidu.live.challenge.d dVar) {
                if (dVar != null) {
                    j.this.hyC.aI(dVar.userId);
                }
            }
        };
        this.mClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.challenge.panel.j.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (view != j.this.hyX) {
                    if (view == j.this.hyW) {
                        j.this.hyV.setText("");
                        return;
                    }
                    return;
                }
                j.this.hyC.cdN();
            }
        };
        this.hza = new TextWatcher() { // from class: com.baidu.tieba.ala.liveroom.challenge.panel.j.5
            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                j.this.pn = 1;
                j.this.bSW = false;
                if (charSequence == null || charSequence.length() == 0) {
                    j.this.hyZ = "";
                    j.this.hyW.setVisibility(8);
                    j.this.hyC.bR(j.this.pn, 30);
                    return;
                }
                j.this.hyZ = charSequence.toString();
                j.this.hyW.setVisibility(0);
                j.this.hyC.j(j.this.pn, 10, j.this.hyZ);
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
            }
        };
        this.hzb = new View.OnFocusChangeListener() { // from class: com.baidu.tieba.ala.liveroom.challenge.panel.j.6
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
        this.hzc = new View.OnTouchListener() { // from class: com.baidu.tieba.ala.liveroom.challenge.panel.j.8
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                BdUtilHelper.hideSoftKeyPad(j.this.mContext, view);
                return false;
            }
        };
        this.hyX = (ImageView) this.mRootView.findViewById(a.f.ala_challenge_user_choose_back);
        this.hyX.setOnClickListener(this.mClickListener);
        this.mListView = (BdListView) this.mRootView.findViewById(a.f.ala_challenge_user_list);
        this.hyY = new i(context);
        this.hyY.a(this.hyQ);
        this.mListView.setAdapter((ListAdapter) this.hyY);
        this.mListView.setOnSrollToBottomListener(new BdListView.OnScrollToBottomListener() { // from class: com.baidu.tieba.ala.liveroom.challenge.panel.j.2
            @Override // com.baidu.live.adp.widget.listview.BdListView.OnScrollToBottomListener
            public void onScrollToBottom() {
                if (j.this.mHasMore && !j.this.bSW) {
                    j.this.bSW = true;
                    if (TextUtils.isEmpty(j.this.hyZ)) {
                        j.this.hyC.bR(j.this.pn, 30);
                    } else {
                        j.this.hyC.j(j.this.pn, 10, j.this.hyZ);
                    }
                }
            }
        });
        this.bSF = new TextView(this.mContext);
        this.bSF.setTextColor(this.mContext.getResources().getColor(a.c.sdk_white_alpha50));
        this.bSF.setTextSize(0, this.mContext.getResources().getDimensionPixelSize(a.d.sdk_fontsize24));
        this.bSF.setPadding(0, this.mContext.getResources().getDimensionPixelSize(a.d.sdk_ds28), 0, this.mContext.getResources().getDimensionPixelSize(a.d.sdk_ds28));
        this.bSF.setGravity(17);
        this.hyW = this.mRootView.findViewById(a.f.delete_search_pk_textview);
        this.hyW.setOnClickListener(this.mClickListener);
        this.hyV = (EditText) this.mRootView.findViewById(a.f.search_pk_edittext);
        this.hyV.addTextChangedListener(this.hza);
        this.hyV.setOnFocusChangeListener(this.hzb);
        this.hyV.setOnEditorActionListener(this.mOnEditorActionListener);
        this.hyV.setOnTouchListener(this.hzc);
        this.mListView.setOnTouchListener(this.hzc);
        this.mRootView.setOnTouchListener(this.hzc);
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
        this.bSW = false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.ala.liveroom.challenge.panel.g
    public boolean onBackKeyDown() {
        this.hyC.cdN();
        return true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.ala.liveroom.challenge.panel.g
    public int cdz() {
        return this.mContext.getResources().getDimensionPixelSize(a.d.sdk_ds560) * 2;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.ala.liveroom.challenge.panel.g
    public void cdR() {
        super.cdR();
        BdUtilHelper.hideSoftKeyPad(this.mContext, this.hyV);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.ala.liveroom.challenge.panel.g
    public void hide() {
        super.hide();
        if (this.hyY != null) {
            this.mListView.setSelection(0);
            this.mListView.removeFooterView(this.bSF);
            this.hyY.cdU();
        }
        this.hyV.setText("");
        Xc();
    }

    public void j(com.baidu.live.challenge.d dVar) {
        if (this.hyY != null) {
            this.hyY.i(dVar);
        }
    }

    public void cdG() {
        if (this.hyY != null) {
            this.hyY.notifyDataSetChanged();
        }
    }

    public void a(int i, CommonEmptyView.ImgType imgType) {
        if (this.mContext != null) {
            if (this.byj == null) {
                this.byj = new CommonEmptyView(this.mContext);
                if (this.mRootView instanceof RelativeLayout) {
                    this.byj.addToParent((RelativeLayout) this.mRootView);
                } else if (this.mRootView instanceof FrameLayout) {
                    this.byj.addToParent((FrameLayout) this.mRootView);
                }
            }
            this.byj.setTitle(i);
            this.byj.setup(imgType, CommonEmptyView.StyleType.DARK);
            if (imgType == CommonEmptyView.ImgType.NO_NET || imgType == CommonEmptyView.ImgType.SERVER_ERROR) {
                this.byj.setRefreshButton(a.h.ala_click_retry, this.bSL);
            }
            this.byj.setVisibility(0);
        }
    }

    public void Xc() {
        if (this.byj != null) {
            this.byj.setVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void b(com.baidu.live.challenge.b bVar, List<com.baidu.live.challenge.d> list) {
        this.bSW = false;
        if (bVar != null && this.mRootView.getParent() != null) {
            if (ListUtils.isEmpty(list) && bVar.pn == 1) {
                this.mListView.setVisibility(8);
                if (TextUtils.isEmpty(this.hyZ)) {
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
            Xc();
            if (bVar.pn == 1) {
                this.hyY.setDatas(list);
            } else {
                this.hyY.cE(list);
            }
            this.pn = bVar.pn + 1;
            this.mHasMore = bVar.hasMore;
            if (bVar.hasMore) {
                Xa();
            } else {
                Xb();
            }
        }
    }

    private void Xa() {
        this.bSF.setText(this.mContext.getString(a.h.sdk_loading_text_with_ellipsis));
        this.mListView.removeFooterView(this.bSF);
        this.mListView.addFooterView(this.bSF);
    }

    private void Xb() {
        this.bSF.setText(this.mContext.getString(a.h.sdk_list_no_more));
        this.mListView.removeFooterView(this.bSF);
        this.mListView.addFooterView(this.bSF);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void bn(int i, String str) {
        this.bSW = false;
        BdUtilHelper.showToast(this.mContext, str);
        if (this.hyY.getCount() <= 0 || this.pn == 1) {
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
