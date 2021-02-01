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
/* loaded from: classes11.dex */
public class j extends g {
    private TextView bRf;
    private View.OnClickListener bRl;
    private boolean bRw;
    private CommonEmptyView bwJ;
    public a hwT;
    private EditText hwY;
    private View hwZ;
    private ImageView hxa;
    private i hxb;
    private String hxc;
    private TextWatcher hxd;
    private View.OnFocusChangeListener hxe;
    private View.OnTouchListener hxf;
    private View.OnClickListener mClickListener;
    private boolean mHasMore;
    private BdListView mListView;
    private TextView.OnEditorActionListener mOnEditorActionListener;
    private int pn;

    /* loaded from: classes11.dex */
    public interface a {
        void f(com.baidu.live.challenge.d dVar);
    }

    public j(Context context, n nVar) {
        super(context, nVar);
        this.pn = 1;
        this.bRl = new View.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.challenge.panel.j.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                j.this.pn = 1;
                j.this.bRw = false;
                if (TextUtils.isEmpty(j.this.hxc)) {
                    j.this.hwF.bQ(j.this.pn, 30);
                } else {
                    j.this.hwF.j(j.this.pn, 10, j.this.hxc);
                }
            }
        };
        this.hwT = new a() { // from class: com.baidu.tieba.ala.liveroom.challenge.panel.j.3
            @Override // com.baidu.tieba.ala.liveroom.challenge.panel.j.a
            public void f(com.baidu.live.challenge.d dVar) {
                if (dVar != null) {
                    j.this.hwF.aI(dVar.userId);
                }
            }
        };
        this.mClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.challenge.panel.j.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (view != j.this.hxa) {
                    if (view == j.this.hwZ) {
                        j.this.hwY.setText("");
                        return;
                    }
                    return;
                }
                j.this.hwF.cdA();
            }
        };
        this.hxd = new TextWatcher() { // from class: com.baidu.tieba.ala.liveroom.challenge.panel.j.5
            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                j.this.pn = 1;
                j.this.bRw = false;
                if (charSequence == null || charSequence.length() == 0) {
                    j.this.hxc = "";
                    j.this.hwZ.setVisibility(8);
                    j.this.hwF.bQ(j.this.pn, 30);
                    return;
                }
                j.this.hxc = charSequence.toString();
                j.this.hwZ.setVisibility(0);
                j.this.hwF.j(j.this.pn, 10, j.this.hxc);
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
            }
        };
        this.hxe = new View.OnFocusChangeListener() { // from class: com.baidu.tieba.ala.liveroom.challenge.panel.j.6
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
        this.hxf = new View.OnTouchListener() { // from class: com.baidu.tieba.ala.liveroom.challenge.panel.j.8
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                BdUtilHelper.hideSoftKeyPad(j.this.mContext, view);
                return false;
            }
        };
        this.hxa = (ImageView) this.mRootView.findViewById(a.f.ala_challenge_user_choose_back);
        this.hxa.setOnClickListener(this.mClickListener);
        this.mListView = (BdListView) this.mRootView.findViewById(a.f.ala_challenge_user_list);
        this.hxb = new i(context);
        this.hxb.a(this.hwT);
        this.mListView.setAdapter((ListAdapter) this.hxb);
        this.mListView.setOnSrollToBottomListener(new BdListView.OnScrollToBottomListener() { // from class: com.baidu.tieba.ala.liveroom.challenge.panel.j.2
            @Override // com.baidu.live.adp.widget.listview.BdListView.OnScrollToBottomListener
            public void onScrollToBottom() {
                if (j.this.mHasMore && !j.this.bRw) {
                    j.this.bRw = true;
                    if (TextUtils.isEmpty(j.this.hxc)) {
                        j.this.hwF.bQ(j.this.pn, 30);
                    } else {
                        j.this.hwF.j(j.this.pn, 10, j.this.hxc);
                    }
                }
            }
        });
        this.bRf = new TextView(this.mContext);
        this.bRf.setTextColor(this.mContext.getResources().getColor(a.c.sdk_white_alpha50));
        this.bRf.setTextSize(0, this.mContext.getResources().getDimensionPixelSize(a.d.sdk_fontsize24));
        this.bRf.setPadding(0, this.mContext.getResources().getDimensionPixelSize(a.d.sdk_ds28), 0, this.mContext.getResources().getDimensionPixelSize(a.d.sdk_ds28));
        this.bRf.setGravity(17);
        this.hwZ = this.mRootView.findViewById(a.f.delete_search_pk_textview);
        this.hwZ.setOnClickListener(this.mClickListener);
        this.hwY = (EditText) this.mRootView.findViewById(a.f.search_pk_edittext);
        this.hwY.addTextChangedListener(this.hxd);
        this.hwY.setOnFocusChangeListener(this.hxe);
        this.hwY.setOnEditorActionListener(this.mOnEditorActionListener);
        this.hwY.setOnTouchListener(this.hxf);
        this.mListView.setOnTouchListener(this.hxf);
        this.mRootView.setOnTouchListener(this.hxf);
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
        this.bRw = false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.ala.liveroom.challenge.panel.g
    public boolean onBackKeyDown() {
        this.hwF.cdA();
        return true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.ala.liveroom.challenge.panel.g
    public int cdm() {
        return this.mContext.getResources().getDimensionPixelSize(a.d.sdk_ds560) * 2;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.ala.liveroom.challenge.panel.g
    public void cdE() {
        super.cdE();
        BdUtilHelper.hideSoftKeyPad(this.mContext, this.hwY);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.ala.liveroom.challenge.panel.g
    public void hide() {
        super.hide();
        if (this.hxb != null) {
            this.mListView.setSelection(0);
            this.mListView.removeFooterView(this.bRf);
            this.hxb.cdH();
        }
        this.hwY.setText("");
        WZ();
    }

    public void j(com.baidu.live.challenge.d dVar) {
        if (this.hxb != null) {
            this.hxb.i(dVar);
        }
    }

    public void cdt() {
        if (this.hxb != null) {
            this.hxb.notifyDataSetChanged();
        }
    }

    public void a(int i, CommonEmptyView.ImgType imgType) {
        if (this.mContext != null) {
            if (this.bwJ == null) {
                this.bwJ = new CommonEmptyView(this.mContext);
                if (this.mRootView instanceof RelativeLayout) {
                    this.bwJ.addToParent((RelativeLayout) this.mRootView);
                } else if (this.mRootView instanceof FrameLayout) {
                    this.bwJ.addToParent((FrameLayout) this.mRootView);
                }
            }
            this.bwJ.setTitle(i);
            this.bwJ.setup(imgType, CommonEmptyView.StyleType.DARK);
            if (imgType == CommonEmptyView.ImgType.NO_NET || imgType == CommonEmptyView.ImgType.SERVER_ERROR) {
                this.bwJ.setRefreshButton(a.h.ala_click_retry, this.bRl);
            }
            this.bwJ.setVisibility(0);
        }
    }

    public void WZ() {
        if (this.bwJ != null) {
            this.bwJ.setVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void b(com.baidu.live.challenge.b bVar, List<com.baidu.live.challenge.d> list) {
        this.bRw = false;
        if (bVar != null && this.mRootView.getParent() != null) {
            if (ListUtils.isEmpty(list) && bVar.pn == 1) {
                this.mListView.setVisibility(8);
                if (TextUtils.isEmpty(this.hxc)) {
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
            WZ();
            if (bVar.pn == 1) {
                this.hxb.setDatas(list);
            } else {
                this.hxb.cE(list);
            }
            this.pn = bVar.pn + 1;
            this.mHasMore = bVar.hasMore;
            if (bVar.hasMore) {
                WX();
            } else {
                WY();
            }
        }
    }

    private void WX() {
        this.bRf.setText(this.mContext.getString(a.h.sdk_loading_text_with_ellipsis));
        this.mListView.removeFooterView(this.bRf);
        this.mListView.addFooterView(this.bRf);
    }

    private void WY() {
        this.bRf.setText(this.mContext.getString(a.h.sdk_list_no_more));
        this.mListView.removeFooterView(this.bRf);
        this.mListView.addFooterView(this.bRf);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void bn(int i, String str) {
        this.bRw = false;
        BdUtilHelper.showToast(this.mContext, str);
        if (this.hxb.getCount() <= 0 || this.pn == 1) {
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
