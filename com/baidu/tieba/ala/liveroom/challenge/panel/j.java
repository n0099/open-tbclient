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
/* loaded from: classes7.dex */
public class j extends g {
    private CommonEmptyView bgn;
    private View.OnClickListener fSJ;
    private i gsA;
    private TextView gsB;
    private boolean gsC;
    private String gsD;
    private TextWatcher gsE;
    private View.OnFocusChangeListener gsF;
    private View.OnTouchListener gsG;
    public a gss;
    private EditText gsx;
    private View gsy;
    private ImageView gsz;
    private View.OnClickListener mClickListener;
    private boolean mHasMore;
    private BdListView mListView;
    private TextView.OnEditorActionListener mOnEditorActionListener;
    private int pn;

    /* loaded from: classes7.dex */
    public interface a {
        void f(com.baidu.live.challenge.d dVar);
    }

    public j(Context context, m mVar) {
        super(context, mVar);
        this.pn = 1;
        this.fSJ = new View.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.challenge.panel.j.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                j.this.pn = 1;
                j.this.gsC = false;
                if (TextUtils.isEmpty(j.this.gsD)) {
                    j.this.gse.bM(j.this.pn, 30);
                } else {
                    j.this.gse.h(j.this.pn, 10, j.this.gsD);
                }
            }
        };
        this.gss = new a() { // from class: com.baidu.tieba.ala.liveroom.challenge.panel.j.3
            @Override // com.baidu.tieba.ala.liveroom.challenge.panel.j.a
            public void f(com.baidu.live.challenge.d dVar) {
                if (dVar != null) {
                    j.this.gse.W(dVar.userId);
                }
            }
        };
        this.mClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.challenge.panel.j.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (view != j.this.gsz) {
                    if (view == j.this.gsy) {
                        j.this.gsx.setText("");
                        return;
                    }
                    return;
                }
                j.this.gse.bQe();
            }
        };
        this.gsE = new TextWatcher() { // from class: com.baidu.tieba.ala.liveroom.challenge.panel.j.5
            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                j.this.pn = 1;
                j.this.gsC = false;
                if (charSequence == null || charSequence.length() == 0) {
                    j.this.gsD = "";
                    j.this.gsy.setVisibility(8);
                    j.this.gse.bM(j.this.pn, 30);
                    return;
                }
                j.this.gsD = charSequence.toString();
                j.this.gsy.setVisibility(0);
                j.this.gse.h(j.this.pn, 10, j.this.gsD);
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
            }
        };
        this.gsF = new View.OnFocusChangeListener() { // from class: com.baidu.tieba.ala.liveroom.challenge.panel.j.6
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
        this.gsG = new View.OnTouchListener() { // from class: com.baidu.tieba.ala.liveroom.challenge.panel.j.8
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                BdUtilHelper.hideSoftKeyPad(j.this.mContext, view);
                return false;
            }
        };
        this.gsz = (ImageView) this.mRootView.findViewById(a.g.ala_challenge_user_choose_back);
        this.gsz.setOnClickListener(this.mClickListener);
        this.mListView = (BdListView) this.mRootView.findViewById(a.g.ala_challenge_user_list);
        this.gsA = new i(context);
        this.gsA.a(this.gss);
        this.mListView.setAdapter((ListAdapter) this.gsA);
        this.mListView.setOnSrollToBottomListener(new BdListView.OnScrollToBottomListener() { // from class: com.baidu.tieba.ala.liveroom.challenge.panel.j.2
            @Override // com.baidu.live.adp.widget.listview.BdListView.OnScrollToBottomListener
            public void onScrollToBottom() {
                if (j.this.mHasMore && !j.this.gsC) {
                    j.this.gsC = true;
                    if (TextUtils.isEmpty(j.this.gsD)) {
                        j.this.gse.bM(j.this.pn, 30);
                    } else {
                        j.this.gse.h(j.this.pn, 10, j.this.gsD);
                    }
                }
            }
        });
        this.gsB = new TextView(this.mContext);
        this.gsB.setTextColor(this.mContext.getResources().getColor(a.d.sdk_white_alpha50));
        this.gsB.setTextSize(0, this.mContext.getResources().getDimensionPixelSize(a.e.sdk_fontsize24));
        this.gsB.setPadding(0, this.mContext.getResources().getDimensionPixelSize(a.e.sdk_ds28), 0, this.mContext.getResources().getDimensionPixelSize(a.e.sdk_ds28));
        this.gsB.setGravity(17);
        this.gsy = this.mRootView.findViewById(a.g.delete_search_pk_textview);
        this.gsy.setOnClickListener(this.mClickListener);
        this.gsx = (EditText) this.mRootView.findViewById(a.g.search_pk_edittext);
        this.gsx.addTextChangedListener(this.gsE);
        this.gsx.setOnFocusChangeListener(this.gsF);
        this.gsx.setOnEditorActionListener(this.mOnEditorActionListener);
        this.gsx.setOnTouchListener(this.gsG);
        this.mListView.setOnTouchListener(this.gsG);
        this.mRootView.setOnTouchListener(this.gsG);
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
        this.gsC = false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.ala.liveroom.challenge.panel.g
    public boolean onBackKeyDown() {
        this.gse.bQe();
        return true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.ala.liveroom.challenge.panel.g
    public int bPQ() {
        return this.mContext.getResources().getDimensionPixelSize(a.e.sdk_ds560) * 2;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.ala.liveroom.challenge.panel.g
    public void bQh() {
        super.bQh();
        BdUtilHelper.hideSoftKeyPad(this.mContext, this.gsx);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.ala.liveroom.challenge.panel.g
    public void hide() {
        super.hide();
        if (this.gsA != null) {
            this.mListView.setSelection(0);
            this.mListView.removeFooterView(this.gsB);
            this.gsA.bQk();
        }
        this.gsx.setText("");
        bFX();
    }

    public void j(com.baidu.live.challenge.d dVar) {
        if (this.gsA != null) {
            this.gsA.i(dVar);
        }
    }

    public void bPX() {
        if (this.gsA != null) {
            this.gsA.notifyDataSetChanged();
        }
    }

    public void a(int i, CommonEmptyView.ImgType imgType) {
        if (this.mContext != null) {
            if (this.bgn == null) {
                this.bgn = new CommonEmptyView(this.mContext);
                if (this.mRootView instanceof RelativeLayout) {
                    this.bgn.addToParent((RelativeLayout) this.mRootView);
                } else if (this.mRootView instanceof FrameLayout) {
                    this.bgn.addToParent((FrameLayout) this.mRootView);
                }
            }
            this.bgn.setTitle(i);
            this.bgn.setup(imgType, CommonEmptyView.StyleType.DARK);
            if (imgType == CommonEmptyView.ImgType.NO_NET || imgType == CommonEmptyView.ImgType.SERVER_ERROR) {
                this.bgn.setRefreshButton(a.i.ala_click_retry, this.fSJ);
            }
            this.bgn.setVisibility(0);
        }
    }

    public void bFX() {
        if (this.bgn != null) {
            this.bgn.setVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void b(com.baidu.live.challenge.b bVar, List<com.baidu.live.challenge.d> list) {
        this.gsC = false;
        if (bVar != null && this.mRootView.getParent() != null) {
            if (ListUtils.isEmpty(list) && bVar.pn == 1) {
                this.mListView.setVisibility(8);
                if (TextUtils.isEmpty(this.gsD)) {
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
            bFX();
            if (bVar.pn == 1) {
                this.gsA.setDatas(list);
            } else {
                this.gsA.bY(list);
            }
            this.pn = bVar.pn + 1;
            this.mHasMore = bVar.hasMore;
            if (bVar.hasMore) {
                bGS();
            } else {
                bGT();
            }
        }
    }

    private void bGS() {
        this.gsB.setText(this.mContext.getString(a.i.sdk_loading_text_with_ellipsis));
        this.mListView.removeFooterView(this.gsB);
        this.mListView.addFooterView(this.gsB);
    }

    private void bGT() {
        this.gsB.setText(this.mContext.getString(a.i.sdk_list_no_more));
        this.mListView.removeFooterView(this.gsB);
        this.mListView.addFooterView(this.gsB);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void aQ(int i, String str) {
        this.gsC = false;
        BdUtilHelper.showToast(this.mContext, str);
        if (this.gsA.getCount() <= 0 || this.pn == 1) {
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
