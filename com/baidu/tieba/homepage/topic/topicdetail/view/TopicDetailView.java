package com.baidu.tieba.homepage.topic.topicdetail.view;

import android.graphics.Bitmap;
import android.graphics.Typeface;
import android.graphics.drawable.BitmapDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.Editable;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.lib.util.j;
import com.baidu.adp.lib.util.l;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.adp.widget.ListView.BdTypeRecyclerView;
import com.baidu.adp.widget.ListView.m;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.ShareDialogConfig;
import com.baidu.tbadk.core.data.AntiData;
import com.baidu.tbadk.core.data.bg;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.bc;
import com.baidu.tbadk.core.util.v;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tbadk.core.view.PbListView;
import com.baidu.tbadk.coreExtra.data.WriteData;
import com.baidu.tbadk.coreExtra.data.x;
import com.baidu.tbadk.m.g;
import com.baidu.tbadk.m.h;
import com.baidu.tieba.d;
import com.baidu.tieba.homepage.topic.topicdetail.TopicDetailActivity;
import com.baidu.tieba.homepage.topic.topicdetail.model.a;
import com.baidu.tieba.homepage.topic.topictab.view.TopicPkView;
import com.baidu.tieba.tbadkCore.writeModel.NewWriteModel;
import com.baidu.tieba.tbadkCore.writeModel.PostWriteCallBackData;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes4.dex */
public class TopicDetailView extends RelativeLayout implements View.OnClickListener {
    private g cXm;
    private com.baidu.tbadk.editortools.pb.b ckm;
    private NoNetworkView dbm;
    private PbListView dbn;
    private NoNetworkView.a emM;
    private com.baidu.tieba.homepage.topic.topicdetail.a fOY;
    private ImageView fOZ;
    private TopicDetailHeadView fPa;
    private com.baidu.tieba.homepage.topic.topicdetail.a.b fPb;
    private View fPc;
    private View fPd;
    private TextView fPe;
    private TextView fPf;
    private a fPg;
    private View fPh;
    private com.baidu.tieba.write.b fPi;
    private EditText fPj;
    private int fPk;
    private com.baidu.tieba.homepage.topic.topicdetail.model.a fPl;
    a.RunnableC0304a fPm;
    private int fPn;
    private int fPo;
    private NewWriteModel.d fPp;
    private View faK;
    private BdTypeRecyclerView fxI;
    private ImageView mBackImageView;
    private boolean mHasMore;
    private NavigationBar mNavigationBar;
    private BdListView.e mOnScrollToBottomListener;
    private TbPageContext<?> mPageContext;
    private h mRefreshView;
    private final RecyclerView.OnScrollListener mScrollListener;
    private int mSkinType;
    private com.baidu.tieba.homepage.topic.topicdetail.b.a mTopicDetailData;

    public TopicDetailView(TbPageContext<?> tbPageContext, com.baidu.tieba.homepage.topic.topicdetail.a aVar, Bundle bundle) {
        super(tbPageContext.getPageActivity());
        this.mSkinType = 3;
        this.fPd = null;
        this.fPe = null;
        this.fPf = null;
        this.mHasMore = true;
        this.fPn = 0;
        this.fPo = 44;
        this.emM = new NoNetworkView.a() { // from class: com.baidu.tieba.homepage.topic.topicdetail.view.TopicDetailView.1
            @Override // com.baidu.tbadk.core.view.NoNetworkView.a
            public void dP(boolean z) {
                if (z && TopicDetailView.this.mTopicDetailData == null && TopicDetailView.this.fOY != null) {
                    TopicDetailView.this.fOY.loadData();
                }
            }
        };
        this.ckm = new com.baidu.tbadk.editortools.pb.b() { // from class: com.baidu.tieba.homepage.topic.topicdetail.view.TopicDetailView.6
            @Override // com.baidu.tbadk.editortools.pb.b
            public boolean amq() {
                if (TopicDetailView.this.fPi.coa()) {
                    TopicDetailView.this.mPageContext.showToast(TopicDetailView.this.fPi.coc());
                    TopicDetailView.this.kt(true);
                    return true;
                }
                return false;
            }
        };
        this.fPp = new NewWriteModel.d() { // from class: com.baidu.tieba.homepage.topic.topicdetail.view.TopicDetailView.7
            @Override // com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.d
            public void callback(boolean z, PostWriteCallBackData postWriteCallBackData, x xVar, WriteData writeData, AntiData antiData) {
                if (z && TopicDetailView.this.fPg != null && TopicDetailView.this.fPg.alS() != null) {
                    TopicDetailView.this.fPg.alS().hide();
                }
                if (z) {
                    TopicDetailView.this.fPi.Ej(null);
                    TopicDetailView.this.fPi.aE(null);
                    TopicDetailView.this.fPi.qU(false);
                    if (postWriteCallBackData != null) {
                        long d = com.baidu.adp.lib.g.b.d(postWriteCallBackData.getPostId(), 0L);
                        long d2 = com.baidu.adp.lib.g.b.d(postWriteCallBackData.getThreadId(), 0L);
                        if (d != 0 && d2 != 0) {
                            TopicDetailView.this.fPm = TopicDetailView.this.fPl.p(d, d2);
                            com.baidu.adp.lib.g.e.jH().postDelayed(TopicDetailView.this.fPm, 500L);
                        }
                    }
                } else if (postWriteCallBackData != null && postWriteCallBackData.isSensitiveError()) {
                    TopicDetailView.this.fPi.aE(postWriteCallBackData.getSensitiveWords());
                    TopicDetailView.this.fPi.Ej(postWriteCallBackData.getErrorString());
                    if (!v.T(TopicDetailView.this.fPi.cnY())) {
                        TopicDetailView.this.kt(true);
                    }
                }
            }
        };
        this.mScrollListener = new RecyclerView.OnScrollListener() { // from class: com.baidu.tieba.homepage.topic.topicdetail.view.TopicDetailView.8
            @Override // android.support.v7.widget.RecyclerView.OnScrollListener
            public void onScrollStateChanged(RecyclerView recyclerView, int i) {
                if (i != 0 && TopicDetailView.this.fPg != null) {
                    TopicDetailView.this.fPg.amP();
                    TopicDetailView.this.setEditorTopViewAboveEditor();
                }
                super.onScrollStateChanged(TopicDetailView.this.fxI, i);
            }

            @Override // android.support.v7.widget.RecyclerView.OnScrollListener
            public void onScrolled(RecyclerView recyclerView, int i, int i2) {
                super.onScrolled(recyclerView, i, i2);
                TopicDetailView.this.fPn += i2;
                TopicDetailView.this.bnn();
            }
        };
        this.mOnScrollToBottomListener = new BdListView.e() { // from class: com.baidu.tieba.homepage.topic.topicdetail.view.TopicDetailView.9
            @Override // com.baidu.adp.widget.ListView.BdListView.e
            public void onScrollToBottom() {
                if (TopicDetailView.this.mHasMore) {
                    if (!l.lo()) {
                        TopicDetailView.this.aCw();
                        return;
                    }
                    int size = TopicDetailView.this.mTopicDetailData.mDataList.size();
                    if (TopicDetailView.this.mTopicDetailData.mDataList.get(size - 1) instanceof com.baidu.tieba.homepage.topic.topicdetail.b.c) {
                        ((TopicDetailActivity) TopicDetailView.this.mPageContext.getPageActivity()).cN(((com.baidu.tieba.homepage.topic.topicdetail.b.c) TopicDetailView.this.mTopicDetailData.mDataList.get(size - 1)).fOw);
                    }
                }
            }
        };
        this.mPageContext = tbPageContext;
        this.fOY = aVar;
        init(bundle);
        onChangeSkinType();
    }

    private void init(Bundle bundle) {
        LayoutInflater.from(getContext()).inflate(d.h.activity_topic_detail_layout, (ViewGroup) this, true);
        this.mNavigationBar = (NavigationBar) findViewById(d.g.activity_topic_detail_navigation);
        if (this.faK == null) {
            this.faK = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
            this.faK.setOnClickListener(this);
            this.mBackImageView = (ImageView) this.faK.findViewById(d.g.widget_navi_back_button);
        }
        this.fOZ = (ImageView) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, d.h.topic_detail_share_layout, this);
        al.c(this.fOZ, d.f.selector_topbar_share_white);
        al.j(this.mNavigationBar.mCenterText, d.C0277d.cp_btn_a);
        this.mNavigationBar.mCenterText.setTextSize(0, getResources().getDimensionPixelSize(d.e.tbds52));
        this.mNavigationBar.mCenterText.setTypeface(Typeface.defaultFromStyle(1));
        this.dbm = (NoNetworkView) findViewById(d.g.activity_topic_detail_no_network_view);
        this.dbm.a(this.emM);
        this.fPd = findViewById(d.g.pb_editor_tool_comment);
        this.fPe = (TextView) findViewById(d.g.topic_editor_tool_comment_reply_text);
        this.fPe.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.homepage.topic.topicdetail.view.TopicDetailView.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                TopicDetailView.this.bnm();
            }
        });
        this.fPf = (TextView) findViewById(d.g.editor_tool_opinion_text_view);
        this.fPc = findViewById(d.g.activity_topic_detail_editor);
        R(bundle);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
        layoutParams.addRule(12);
        addView(this.fPg.alS(), layoutParams);
        this.fPi = new com.baidu.tieba.write.b();
        this.fPh = findViewById(d.g.activity_topic_detail_editor_top);
        this.fxI = (BdTypeRecyclerView) findViewById(d.g.activity_topic_detail_list);
        this.fxI.setLayoutManager(new LinearLayoutManager(getContext()));
        this.fxI.setFadingEdgeLength(0);
        this.fxI.setOverScrollMode(2);
        this.fxI.setOnSrollToBottomListener(this.mOnScrollToBottomListener);
        this.fxI.addOnScrollListener(this.mScrollListener);
        al.l(this.fxI, d.C0277d.cp_bg_line_d);
        this.fPb = new com.baidu.tieba.homepage.topic.topicdetail.a.b(this.mPageContext, this.fxI);
        this.fPa = new TopicDetailHeadView(getContext());
        this.fPa.fOW.setPkClickListener(new TopicPkView.b() { // from class: com.baidu.tieba.homepage.topic.topicdetail.view.TopicDetailView.4
            @Override // com.baidu.tieba.homepage.topic.topictab.view.TopicPkView.b
            public void sH(int i) {
                TopicDetailView.this.sG(i);
            }
        });
        if (this.cXm == null) {
            this.dbn = new PbListView(this.mPageContext.getPageActivity());
            this.dbn.getView();
        }
        this.dbn.ib(d.C0277d.cp_bg_line_e);
        this.dbn.setHeight(l.h(this.mPageContext.getPageActivity(), d.e.tbds182));
        this.dbn.setTextSize(d.e.tbfontsize33);
        this.dbn.ia(d.C0277d.cp_cont_e);
        this.dbn.setTextColor(al.getColor(d.C0277d.cp_cont_e));
        this.dbn.ib(al.getColor(d.C0277d.cp_bg_line_d));
        this.dbn.hX(al.getColor(d.C0277d.cp_bg_line_c));
        this.dbn.setText(getResources().getString(d.j.list_has_no_more));
        this.dbn.getView().setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
        if (this.fPl == null) {
            this.fPl = new com.baidu.tieba.homepage.topic.topicdetail.model.a(this);
            this.fPl.i(this.mPageContext.getUniqueId());
        }
    }

    private void R(Bundle bundle) {
        this.fPg = (a) new b().dd(getContext());
        if (this.fPg != null) {
            this.fPg.a(this.mPageContext);
            this.fPg.b(this.fPp);
            this.fPg.a(this.ckm);
            this.fPg.alS().eH(true);
            this.fPg.a((BaseActivity) getContext(), bundle);
            this.fPg.amP();
            this.fPg.alS().setId(d.g.topic_editor);
            this.fPj = this.fPg.bnl().getInputView();
            this.fPj.addTextChangedListener(new TextWatcher() { // from class: com.baidu.tieba.homepage.topic.topicdetail.view.TopicDetailView.5
                @Override // android.text.TextWatcher
                public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                }

                @Override // android.text.TextWatcher
                public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                }

                @Override // android.text.TextWatcher
                public void afterTextChanged(Editable editable) {
                    if (TopicDetailView.this.fPi != null) {
                        if (!TopicDetailView.this.fPi.cob()) {
                            TopicDetailView.this.kt(false);
                        }
                        TopicDetailView.this.fPi.qV(false);
                    }
                }
            });
        }
    }

    public void kt(boolean z) {
        if (this.fPj != null && this.fPj.getText() != null) {
            int selectionEnd = this.fPj.getSelectionEnd();
            SpannableStringBuilder b = this.fPi.b(this.fPj.getText());
            if (b != null) {
                this.fPi.qV(true);
                this.fPj.setText(b);
                if (z && this.fPi.cnZ() >= 0) {
                    this.fPj.requestFocus();
                    this.fPj.setSelection(this.fPi.cnZ());
                } else {
                    this.fPj.setSelection(selectionEnd);
                }
                this.fPi.qU(this.fPi.cnZ() >= 0);
            }
        }
    }

    public void bnm() {
        if (bc.cZ(getContext())) {
            this.fPg.amS();
            setEditorTopViewAboveEditor();
        }
        if (this.mTopicDetailData != null) {
            TiebaStatic.log(new am("c13359").bJ("topic_id", String.valueOf(this.mTopicDetailData.topicId)));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void sG(int i) {
        this.fPk = i;
        this.fPf.setVisibility(0);
        if (i == 1) {
            this.fPf.setText(d.j.topic_detail_pk_support);
            al.k(this.fPf, d.f.topic_discuss_support_bg);
        } else if (i == 2) {
            this.fPf.setText(d.j.topic_detail_pk_oppose);
            al.k(this.fPf, d.f.topic_discuss_oppose_bg);
        } else {
            this.fPf.setText(d.j.topic_detail_pk_chigua);
            al.k(this.fPf, d.f.topic_discuss_opinion_bg);
        }
        if (this.mSkinType == 1) {
            this.fPf.setTextColor(-2130706433);
        } else {
            al.j(this.fPf, d.C0277d.cp_btn_a);
        }
    }

    public void setData(com.baidu.tieba.homepage.topic.topicdetail.b.a aVar) {
        int h;
        if (aVar != null) {
            this.mTopicDetailData = aVar;
            this.mHasMore = this.mTopicDetailData.hasMore;
            if (this.mHasMore && this.mTopicDetailData.mDataList.size() <= 4) {
                this.mHasMore = false;
                aCv();
            } else if (!this.mHasMore) {
                aCv();
            } else {
                aCu();
            }
            if (!StringUtils.isNull(aVar.bAm)) {
                this.mNavigationBar.setCenterTextTitle(String.format(getContext().getString(d.j.daily_topic_name), ap.g(aVar.bAm, 14, "...")));
            }
            this.fPa.setData(aVar.fOo);
            this.fxI.addHeaderView(this.fPa);
            this.fPb.setData(aVar.mDataList);
            if (this.mTopicDetailData.fOo.fOt != null) {
                if (this.mTopicDetailData.fOo.fOt.fPR.fPX) {
                    sG(1);
                } else if (this.mTopicDetailData.fOo.fOt.fPS.fPX) {
                    sG(2);
                } else {
                    sG(0);
                }
                h = l.h(TbadkCoreApplication.getInst().getContext(), d.e.tbds130);
            } else {
                h = l.h(TbadkCoreApplication.getInst().getContext(), d.e.tbds50);
                this.fPf.setVisibility(8);
            }
            this.fPe.setPadding(h, 0, 0, 0);
            bnn();
        }
    }

    public void setNextData(int i, boolean z, List<m> list) {
        this.mHasMore = z;
        if (!this.mHasMore) {
            aCv();
        } else {
            aCu();
        }
        if (i == 0 && list != null && !v.T(list)) {
            for (m mVar : list) {
                if (mVar instanceof com.baidu.tieba.homepage.topic.topicdetail.b.c) {
                    ((com.baidu.tieba.homepage.topic.topicdetail.b.c) mVar).fOz = this.mTopicDetailData.bng();
                }
            }
            this.mTopicDetailData.mDataList.addAll(list);
            this.fxI.setData(this.mTopicDetailData.mDataList);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aCw() {
        this.fxI.setNextPage(null);
    }

    public void aCu() {
        this.mHasMore = true;
        this.fxI.setNextPage(this.dbn);
        this.dbn.aeC();
    }

    public void aCv() {
        this.fxI.setNextPage(this.dbn);
        this.dbn.aeD();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.faK) {
            this.mPageContext.getPageActivity().finish();
        } else if (view == this.fOZ && this.mTopicDetailData.topicId > 0) {
            aeX();
            TiebaStatic.log(new am("c13364").bJ("topic_id", String.valueOf(this.mTopicDetailData.topicId)));
        }
    }

    private void aeX() {
        if (this.mTopicDetailData != null && getContext() != null) {
            String valueOf = String.valueOf(this.mTopicDetailData.topicId);
            String str = this.mTopicDetailData.bAm;
            String str2 = this.mTopicDetailData.shareTitle;
            if (TextUtils.isEmpty(valueOf) || TextUtils.isEmpty(str)) {
                this.mPageContext.showToast(getContext().getString(d.j.no_hot_topic_data));
                return;
            }
            String str3 = "http://tieba.baidu.com/mo/q/newtopic/detail?topic_id=" + valueOf + "/";
            Uri parse = StringUtils.isNull(this.mTopicDetailData.fOn) ? null : Uri.parse(this.mTopicDetailData.fOn);
            final com.baidu.tbadk.coreExtra.c.d dVar = new com.baidu.tbadk.coreExtra.c.d();
            dVar.title = str;
            dVar.content = str2;
            dVar.linkUrl = str3;
            dVar.cbp = true;
            dVar.extData = valueOf;
            dVar.imageUri = parse;
            ShareDialogConfig shareDialogConfig = new ShareDialogConfig(getContext(), dVar, true, true);
            shareDialogConfig.setIsCopyLink(true);
            shareDialogConfig.setCopyLinkListener(new View.OnClickListener() { // from class: com.baidu.tieba.homepage.topic.topicdetail.view.TopicDetailView.10
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    com.baidu.adp.lib.util.a.bh(dVar.linkUrl);
                    l.showToast(TopicDetailView.this.getContext(), view.getResources().getString(d.j.copy_pb_url_success));
                }
            });
            this.mPageContext.sendMessage(new CustomMessage(2001276, shareDialogConfig));
        }
    }

    public void onChangeSkinType() {
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        if (skinType != this.mSkinType) {
            this.mSkinType = skinType;
            bnn();
            al.j(this.mNavigationBar.mCenterText, d.C0277d.cp_btn_a);
            al.k(this.fPd, d.C0277d.cp_cont_g);
            al.j(this.fPe, d.C0277d.cp_cont_d);
            al.k(this.fPe, d.f.topic_discuss_input_bg);
            sG(this.fPk);
            al.c(this.mBackImageView, d.f.icon_topbar_return_white_n, d.f.icon_topbar_return_white_s);
            if (this.fOZ != null) {
                al.c(this.fOZ, d.f.selector_topbar_share_white);
            }
            if (this.mPageContext != null && this.dbm != null) {
                this.dbm.onChangeSkinType(this.mPageContext, this.mSkinType);
            }
            if (this.cXm != null) {
                this.cXm.onChangeSkinType();
            }
            if (this.mRefreshView != null) {
                this.mRefreshView.onChangeSkinType();
            }
            if (this.fPg != null && this.fPg.alS() != null) {
                this.fPg.alS().onChangeSkinType(this.mSkinType);
            }
            if (this.dbn != null) {
                this.dbn.ia(d.C0277d.cp_cont_e);
                this.dbn.setTextColor(al.getColor(d.C0277d.cp_cont_e));
                this.dbn.ib(al.getColor(d.C0277d.cp_bg_line_d));
                this.dbn.hX(al.getColor(d.C0277d.cp_bg_line_c));
            }
            if (this.fPa != null) {
                this.fPa.onChangeSkinType();
            }
            if (this.fPb != null) {
                this.fPb.notifyDataSetChanged();
            }
            al.l(this.fxI, d.C0277d.cp_bg_line_d);
        }
    }

    public void cE(boolean z) {
        if (!aXq()) {
            if (this.cXm == null) {
                this.cXm = new g(getContext());
                this.cXm.onChangeSkinType();
            }
            this.cXm.attachView(this, z);
        }
    }

    public void hideLoadingView() {
        if (this.cXm != null) {
            this.cXm.dettachView(this);
            this.cXm = null;
        }
    }

    public boolean aXq() {
        if (this.cXm != null) {
            return this.cXm.isViewAttached();
        }
        return false;
    }

    public void iD(boolean z) {
        if (!aXr()) {
            if (this.mRefreshView == null) {
                this.mRefreshView = new h(getContext(), new View.OnClickListener() { // from class: com.baidu.tieba.homepage.topic.topicdetail.view.TopicDetailView.2
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        if (j.kM() && TopicDetailView.this.fOY != null) {
                            TopicDetailView.this.fOY.loadData();
                        }
                    }
                });
            }
            this.mRefreshView.jR(this.mPageContext.getResources().getDimensionPixelSize(d.e.ds380));
            this.mRefreshView.attachView(this, z);
            this.mRefreshView.anB();
            this.fxI.setVisibility(8);
        }
    }

    public void aBt() {
        if (this.mRefreshView != null) {
            this.mRefreshView.dettachView(this);
            this.mRefreshView = null;
        }
        this.fxI.setVisibility(0);
    }

    public boolean aXr() {
        if (this.mRefreshView != null) {
            return this.mRefreshView.isViewAttached();
        }
        return false;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        destroy();
        super.onDetachedFromWindow();
    }

    public void destroy() {
        this.fxI.setOnSrollToBottomListener(null);
        if (this.dbm != null) {
            this.dbm.b(this.emM);
        }
        if (this.fPg != null) {
            this.fPg.onDestory();
        }
        if (this.fPm != null) {
            com.baidu.adp.lib.g.e.jH().removeCallbacks(this.fPm);
        }
        hideLoadingView();
        aBt();
    }

    public a getEditor() {
        return this.fPg;
    }

    public void setEditorTopViewAboveEditor() {
        if (this.fPh != null) {
            ViewGroup.LayoutParams layoutParams = this.fPh.getLayoutParams();
            if (layoutParams instanceof RelativeLayout.LayoutParams) {
                RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) layoutParams;
                if (this.fPg.alS().isVisible()) {
                    layoutParams2.addRule(2, this.fPg.alS().getId());
                } else {
                    layoutParams2.addRule(2, this.fPc.getId());
                }
                this.fPh.setLayoutParams(layoutParams2);
            }
        }
    }

    public void au(bg bgVar) {
        int i;
        com.baidu.tieba.homepage.topic.topicdetail.b.c cVar;
        int i2 = 0;
        Iterator<m> it = this.mTopicDetailData.mDataList.iterator();
        while (true) {
            i = i2;
            if (!it.hasNext()) {
                cVar = null;
                break;
            }
            m next = it.next();
            if (next instanceof com.baidu.tieba.homepage.topic.topicdetail.b.c) {
                cVar = (com.baidu.tieba.homepage.topic.topicdetail.b.c) next;
                break;
            }
            i2 = i + 1;
        }
        if (cVar != null) {
            com.baidu.tieba.homepage.topic.topicdetail.b.c cVar2 = new com.baidu.tieba.homepage.topic.topicdetail.b.c();
            cVar2.fOw = cVar.fOw;
            cVar2.threadData = bgVar;
            cVar2.fOy = 2;
            cVar2.fOx = this.fPk;
            cVar2.topicId = this.mTopicDetailData.topicId;
            cVar2.fOz = this.mTopicDetailData.bng();
            this.mTopicDetailData.mDataList.add(i, cVar2);
            this.fPb.setData(this.mTopicDetailData.mDataList);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bnn() {
        if (this.mTopicDetailData != null && this.fPa != null) {
            if (this.fPn > this.fPo) {
                this.mNavigationBar.getBarBgView().setAlpha(1.0f);
                this.mNavigationBar.getBarBgView().setBackgroundDrawable(new BitmapDrawable(bno()));
                return;
            }
            al.l(this.mNavigationBar.getBarBgView(), d.C0277d.transparent);
            this.mNavigationBar.getBarBgView().setAlpha(0.0f);
        }
    }

    public Bitmap bno() {
        Bitmap drawingCache;
        com.baidu.adp.widget.ImageView.a bdImage = this.fPa.getmBgImg().getBdImage();
        if (bdImage != null) {
            drawingCache = bdImage.oy();
        } else {
            drawingCache = this.fPa.getmBgImg().getDrawingCache();
        }
        int width = this.mPageContext.getPageActivity().getWindowManager().getDefaultDisplay().getWidth();
        int height = this.mNavigationBar.getHeight();
        if (drawingCache != null && drawingCache.getWidth() >= width && drawingCache.getHeight() >= height) {
            return Bitmap.createBitmap(drawingCache, 0, 0, width, height);
        }
        return drawingCache;
    }
}
