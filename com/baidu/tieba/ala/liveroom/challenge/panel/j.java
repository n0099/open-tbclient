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
/* loaded from: classes3.dex */
public class j extends g {
    private CommonEmptyView baR;
    private View.OnClickListener fCe;
    public a gaY;
    private EditText gbd;
    private View gbe;
    private ImageView gbf;
    private i gbg;
    private TextView gbh;
    private String gbi;
    private TextWatcher gbj;
    private View.OnFocusChangeListener gbk;
    private View.OnTouchListener gbl;
    private View.OnClickListener mClickListener;
    private boolean mHasMore;
    private BdListView mListView;
    private TextView.OnEditorActionListener mOnEditorActionListener;
    private int pn;

    /* loaded from: classes3.dex */
    public interface a {
        void f(com.baidu.live.challenge.d dVar);
    }

    public j(Context context, m mVar) {
        super(context, mVar);
        this.pn = 1;
        this.fCe = new View.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.challenge.panel.j.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                j.this.pn = 1;
                if (TextUtils.isEmpty(j.this.gbi)) {
                    j.this.gaK.bB(j.this.pn, 30);
                } else {
                    j.this.gaK.i(j.this.pn, 10, j.this.gbi);
                }
            }
        };
        this.gaY = new a() { // from class: com.baidu.tieba.ala.liveroom.challenge.panel.j.3
            @Override // com.baidu.tieba.ala.liveroom.challenge.panel.j.a
            public void f(com.baidu.live.challenge.d dVar) {
                if (dVar != null) {
                    j.this.gaK.V(dVar.userId);
                }
            }
        };
        this.mClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.challenge.panel.j.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (view != j.this.gbf) {
                    if (view == j.this.gbe) {
                        j.this.gbd.setText("");
                        return;
                    }
                    return;
                }
                j.this.gaK.bDm();
            }
        };
        this.gbj = new TextWatcher() { // from class: com.baidu.tieba.ala.liveroom.challenge.panel.j.5
            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                j.this.pn = 1;
                if (charSequence == null || charSequence.length() == 0) {
                    j.this.gbi = "";
                    j.this.gbe.setVisibility(8);
                    j.this.gaK.bB(j.this.pn, 30);
                    return;
                }
                j.this.gbi = charSequence.toString();
                j.this.gbe.setVisibility(0);
                j.this.gaK.i(j.this.pn, 10, j.this.gbi);
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
            }
        };
        this.gbk = new View.OnFocusChangeListener() { // from class: com.baidu.tieba.ala.liveroom.challenge.panel.j.6
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
        this.gbl = new View.OnTouchListener() { // from class: com.baidu.tieba.ala.liveroom.challenge.panel.j.8
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                BdUtilHelper.hideSoftKeyPad(j.this.mContext, view);
                return false;
            }
        };
        this.gbf = (ImageView) this.mRootView.findViewById(a.g.ala_challenge_user_choose_back);
        this.gbf.setOnClickListener(this.mClickListener);
        this.mListView = (BdListView) this.mRootView.findViewById(a.g.ala_challenge_user_list);
        this.gbg = new i(context);
        this.gbg.a(this.gaY);
        this.mListView.setAdapter((ListAdapter) this.gbg);
        this.mListView.setOnSrollToBottomListener(new BdListView.OnScrollToBottomListener() { // from class: com.baidu.tieba.ala.liveroom.challenge.panel.j.2
            @Override // com.baidu.live.adp.widget.listview.BdListView.OnScrollToBottomListener
            public void onScrollToBottom() {
                if (j.this.mHasMore) {
                    if (TextUtils.isEmpty(j.this.gbi)) {
                        j.this.gaK.bB(j.this.pn, 30);
                    } else {
                        j.this.gaK.i(j.this.pn, 10, j.this.gbi);
                    }
                }
            }
        });
        this.gbh = new TextView(this.mContext);
        this.gbh.setTextColor(this.mContext.getResources().getColor(a.d.sdk_white_alpha50));
        this.gbh.setTextSize(0, this.mContext.getResources().getDimensionPixelSize(a.e.sdk_fontsize24));
        this.gbh.setPadding(0, this.mContext.getResources().getDimensionPixelSize(a.e.sdk_ds28), 0, this.mContext.getResources().getDimensionPixelSize(a.e.sdk_ds28));
        this.gbh.setGravity(17);
        this.gbe = this.mRootView.findViewById(a.g.delete_search_pk_textview);
        this.gbe.setOnClickListener(this.mClickListener);
        this.gbd = (EditText) this.mRootView.findViewById(a.g.search_pk_edittext);
        this.gbd.addTextChangedListener(this.gbj);
        this.gbd.setOnFocusChangeListener(this.gbk);
        this.gbd.setOnEditorActionListener(this.mOnEditorActionListener);
        this.gbd.setOnTouchListener(this.gbl);
        this.mListView.setOnTouchListener(this.gbl);
        this.mRootView.setOnTouchListener(this.gbl);
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
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.ala.liveroom.challenge.panel.g
    public boolean onBackKeyDown() {
        this.gaK.bDm();
        return true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.ala.liveroom.challenge.panel.g
    public int bCY() {
        return this.mContext.getResources().getDimensionPixelSize(a.e.sdk_ds560) * 2;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.ala.liveroom.challenge.panel.g
    public void bDp() {
        super.bDp();
        BdUtilHelper.hideSoftKeyPad(this.mContext, this.gbd);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.ala.liveroom.challenge.panel.g
    public void hide() {
        super.hide();
        if (this.gbg != null) {
            this.mListView.setSelection(0);
            this.mListView.removeFooterView(this.gbh);
            this.gbg.bDs();
        }
        this.gbd.setText("");
        btN();
    }

    public void j(com.baidu.live.challenge.d dVar) {
        if (this.gbg != null) {
            this.gbg.i(dVar);
        }
    }

    public void bDf() {
        if (this.gbg != null) {
            this.gbg.notifyDataSetChanged();
        }
    }

    public void a(int i, CommonEmptyView.ImgType imgType) {
        if (this.mContext != null) {
            if (this.baR == null) {
                this.baR = new CommonEmptyView(this.mContext);
                if (this.mRootView instanceof RelativeLayout) {
                    this.baR.addToParent((RelativeLayout) this.mRootView);
                } else if (this.mRootView instanceof FrameLayout) {
                    this.baR.addToParent((FrameLayout) this.mRootView);
                }
            }
            this.baR.setTitle(i);
            this.baR.setup(imgType, CommonEmptyView.StyleType.DARK);
            if (imgType == CommonEmptyView.ImgType.NO_NET || imgType == CommonEmptyView.ImgType.SERVER_ERROR) {
                this.baR.setRefreshButton(a.i.ala_click_retry, this.fCe);
            }
            this.baR.setVisibility(0);
        }
    }

    public void btN() {
        if (this.baR != null) {
            this.baR.setVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void b(com.baidu.live.challenge.b bVar, List<com.baidu.live.challenge.d> list) {
        if (bVar != null && this.mRootView.getParent() != null) {
            if (ListUtils.isEmpty(list) && bVar.pn == 1) {
                this.mListView.setVisibility(8);
                if (TextUtils.isEmpty(this.gbi)) {
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
            btN();
            if (bVar.pn == 1) {
                this.gbg.setDatas(list);
            } else {
                this.gbg.bT(list);
            }
            this.pn = bVar.pn + 1;
            this.mHasMore = bVar.hasMore;
            if (bVar.hasMore) {
                buI();
            } else {
                buJ();
            }
        }
    }

    private void buI() {
        this.gbh.setText(this.mContext.getString(a.i.sdk_loading_text_with_ellipsis));
        this.mListView.removeFooterView(this.gbh);
        this.mListView.addFooterView(this.gbh);
    }

    private void buJ() {
        this.gbh.setText(this.mContext.getString(a.i.sdk_list_no_more));
        this.mListView.removeFooterView(this.gbh);
        this.mListView.addFooterView(this.gbh);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void aR(int i, String str) {
        BdUtilHelper.showToast(this.mContext, str);
        if (this.gbg.getCount() <= 0 || this.pn == 1) {
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
