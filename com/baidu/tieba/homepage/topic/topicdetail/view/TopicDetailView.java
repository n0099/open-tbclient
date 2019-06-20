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
import com.baidu.tieba.R;
import com.baidu.tieba.homepage.topic.topicdetail.TopicDetailActivity;
import com.baidu.tieba.homepage.topic.topicdetail.model.a;
import com.baidu.tieba.homepage.topic.topictab.view.TopicPkView;
import com.baidu.tieba.tbadkCore.writeModel.NewWriteModel;
import com.baidu.tieba.tbadkCore.writeModel.PostWriteCallBackData;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes4.dex */
public class TopicDetailView extends RelativeLayout implements View.OnClickListener {
    private com.baidu.tbadk.editortools.pb.b csy;
    private g dhY;
    private NoNetworkView dlX;
    private PbListView dlY;
    private NoNetworkView.a eCl;
    private BdTypeRecyclerView fOt;
    private View fqN;
    private com.baidu.tieba.homepage.topic.topicdetail.a gfW;
    private ImageView gfX;
    private TopicDetailHeadView gfY;
    private com.baidu.tieba.homepage.topic.topicdetail.a.b gfZ;
    private View gga;
    private View ggb;
    private TextView ggc;
    private TextView ggd;
    private a gge;
    private View ggf;
    private com.baidu.tieba.write.b ggg;
    private EditText ggh;
    private int ggi;
    private com.baidu.tieba.homepage.topic.topicdetail.model.a ggj;
    a.RunnableC0322a ggk;
    private int ggl;
    private int ggm;
    private NewWriteModel.d ggn;
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
        this.ggb = null;
        this.ggc = null;
        this.ggd = null;
        this.mHasMore = true;
        this.ggl = 0;
        this.ggm = 44;
        this.eCl = new NoNetworkView.a() { // from class: com.baidu.tieba.homepage.topic.topicdetail.view.TopicDetailView.1
            @Override // com.baidu.tbadk.core.view.NoNetworkView.a
            public void el(boolean z) {
                if (z && TopicDetailView.this.mTopicDetailData == null && TopicDetailView.this.gfW != null) {
                    TopicDetailView.this.gfW.loadData();
                }
            }
        };
        this.csy = new com.baidu.tbadk.editortools.pb.b() { // from class: com.baidu.tieba.homepage.topic.topicdetail.view.TopicDetailView.6
            @Override // com.baidu.tbadk.editortools.pb.b
            public boolean arq() {
                if (TopicDetailView.this.ggg.cwf()) {
                    TopicDetailView.this.mPageContext.showToast(TopicDetailView.this.ggg.cwh());
                    TopicDetailView.this.lk(true);
                    return true;
                }
                return false;
            }
        };
        this.ggn = new NewWriteModel.d() { // from class: com.baidu.tieba.homepage.topic.topicdetail.view.TopicDetailView.7
            @Override // com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.d
            public void callback(boolean z, PostWriteCallBackData postWriteCallBackData, x xVar, WriteData writeData, AntiData antiData) {
                if (z && TopicDetailView.this.gge != null && TopicDetailView.this.gge.aqS() != null) {
                    TopicDetailView.this.gge.aqS().hide();
                }
                if (z) {
                    TopicDetailView.this.ggg.FG(null);
                    TopicDetailView.this.ggg.aI(null);
                    TopicDetailView.this.ggg.rK(false);
                    if (postWriteCallBackData != null) {
                        long c = com.baidu.adp.lib.g.b.c(postWriteCallBackData.getPostId(), 0L);
                        long c2 = com.baidu.adp.lib.g.b.c(postWriteCallBackData.getThreadId(), 0L);
                        if (c != 0 && c2 != 0) {
                            TopicDetailView.this.ggk = TopicDetailView.this.ggj.p(c, c2);
                            com.baidu.adp.lib.g.e.iB().postDelayed(TopicDetailView.this.ggk, 500L);
                        }
                    }
                } else if (postWriteCallBackData != null && postWriteCallBackData.isSensitiveError()) {
                    TopicDetailView.this.ggg.aI(postWriteCallBackData.getSensitiveWords());
                    TopicDetailView.this.ggg.FG(postWriteCallBackData.getErrorString());
                    if (!v.aa(TopicDetailView.this.ggg.cwd())) {
                        TopicDetailView.this.lk(true);
                    }
                }
            }
        };
        this.mScrollListener = new RecyclerView.OnScrollListener() { // from class: com.baidu.tieba.homepage.topic.topicdetail.view.TopicDetailView.8
            @Override // android.support.v7.widget.RecyclerView.OnScrollListener
            public void onScrollStateChanged(RecyclerView recyclerView, int i) {
                if (i != 0 && TopicDetailView.this.gge != null) {
                    TopicDetailView.this.gge.arP();
                    TopicDetailView.this.setEditorTopViewAboveEditor();
                }
                super.onScrollStateChanged(TopicDetailView.this.fOt, i);
            }

            @Override // android.support.v7.widget.RecyclerView.OnScrollListener
            public void onScrolled(RecyclerView recyclerView, int i, int i2) {
                super.onScrolled(recyclerView, i, i2);
                TopicDetailView.this.ggl += i2;
                TopicDetailView.this.buQ();
            }
        };
        this.mOnScrollToBottomListener = new BdListView.e() { // from class: com.baidu.tieba.homepage.topic.topicdetail.view.TopicDetailView.9
            @Override // com.baidu.adp.widget.ListView.BdListView.e
            public void onScrollToBottom() {
                if (TopicDetailView.this.mHasMore) {
                    if (!l.ki()) {
                        TopicDetailView.this.aIJ();
                        return;
                    }
                    int size = TopicDetailView.this.mTopicDetailData.mDataList.size();
                    if (TopicDetailView.this.mTopicDetailData.mDataList.get(size - 1) instanceof com.baidu.tieba.homepage.topic.topicdetail.b.c) {
                        ((TopicDetailActivity) TopicDetailView.this.mPageContext.getPageActivity()).dk(((com.baidu.tieba.homepage.topic.topicdetail.b.c) TopicDetailView.this.mTopicDetailData.mDataList.get(size - 1)).gfw);
                    }
                }
            }
        };
        this.mPageContext = tbPageContext;
        this.gfW = aVar;
        init(bundle);
        onChangeSkinType();
    }

    private void init(Bundle bundle) {
        LayoutInflater.from(getContext()).inflate(R.layout.activity_topic_detail_layout, (ViewGroup) this, true);
        this.mNavigationBar = (NavigationBar) findViewById(R.id.activity_topic_detail_navigation);
        if (this.fqN == null) {
            this.fqN = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
            this.fqN.setOnClickListener(this);
            this.mBackImageView = (ImageView) this.fqN.findViewById(R.id.widget_navi_back_button);
        }
        this.gfX = (ImageView) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, R.layout.topic_detail_share_layout, this);
        al.c(this.gfX, (int) R.drawable.selector_topbar_share_white);
        al.j(this.mNavigationBar.mCenterText, R.color.cp_btn_a);
        this.mNavigationBar.mCenterText.setTextSize(0, getResources().getDimensionPixelSize(R.dimen.tbds52));
        this.mNavigationBar.mCenterText.setTypeface(Typeface.defaultFromStyle(1));
        this.dlX = (NoNetworkView) findViewById(R.id.activity_topic_detail_no_network_view);
        this.dlX.a(this.eCl);
        this.ggb = findViewById(R.id.pb_editor_tool_comment);
        this.ggc = (TextView) findViewById(R.id.topic_editor_tool_comment_reply_text);
        this.ggc.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.homepage.topic.topicdetail.view.TopicDetailView.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                TopicDetailView.this.buP();
            }
        });
        this.ggd = (TextView) findViewById(R.id.editor_tool_opinion_text_view);
        this.gga = findViewById(R.id.activity_topic_detail_editor);
        S(bundle);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
        layoutParams.addRule(12);
        addView(this.gge.aqS(), layoutParams);
        this.ggg = new com.baidu.tieba.write.b();
        this.ggf = findViewById(R.id.activity_topic_detail_editor_top);
        this.fOt = (BdTypeRecyclerView) findViewById(R.id.activity_topic_detail_list);
        this.fOt.setLayoutManager(new LinearLayoutManager(getContext()));
        this.fOt.setFadingEdgeLength(0);
        this.fOt.setOverScrollMode(2);
        this.fOt.setOnSrollToBottomListener(this.mOnScrollToBottomListener);
        this.fOt.addOnScrollListener(this.mScrollListener);
        al.l(this.fOt, R.color.cp_bg_line_d);
        this.gfZ = new com.baidu.tieba.homepage.topic.topicdetail.a.b(this.mPageContext, this.fOt);
        this.gfY = new TopicDetailHeadView(getContext());
        this.gfY.gfU.setPkClickListener(new TopicPkView.b() { // from class: com.baidu.tieba.homepage.topic.topicdetail.view.TopicDetailView.4
            @Override // com.baidu.tieba.homepage.topic.topictab.view.TopicPkView.b
            public void tK(int i) {
                TopicDetailView.this.tJ(i);
            }
        });
        if (this.dhY == null) {
            this.dlY = new PbListView(this.mPageContext.getPageActivity());
            this.dlY.getView();
        }
        this.dlY.iO(R.color.cp_bg_line_e);
        this.dlY.setHeight(l.g(this.mPageContext.getPageActivity(), R.dimen.tbds182));
        this.dlY.setTextSize(R.dimen.tbfontsize33);
        this.dlY.iN(R.color.cp_cont_e);
        this.dlY.setTextColor(al.getColor(R.color.cp_cont_e));
        this.dlY.iO(al.getColor(R.color.cp_bg_line_d));
        this.dlY.iK(al.getColor(R.color.cp_bg_line_c));
        this.dlY.setText(getResources().getString(R.string.list_has_no_more));
        this.dlY.getView().setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
        if (this.ggj == null) {
            this.ggj = new com.baidu.tieba.homepage.topic.topicdetail.model.a(this);
            this.ggj.i(this.mPageContext.getUniqueId());
        }
    }

    private void S(Bundle bundle) {
        this.gge = (a) new b().cJ(getContext());
        if (this.gge != null) {
            this.gge.a(this.mPageContext);
            this.gge.b(this.ggn);
            this.gge.a(this.csy);
            this.gge.aqS().fd(true);
            this.gge.a((BaseActivity) getContext(), bundle);
            this.gge.arP();
            this.gge.aqS().setId(R.id.topic_editor);
            this.ggh = this.gge.buO().getInputView();
            this.ggh.addTextChangedListener(new TextWatcher() { // from class: com.baidu.tieba.homepage.topic.topicdetail.view.TopicDetailView.5
                @Override // android.text.TextWatcher
                public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                }

                @Override // android.text.TextWatcher
                public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                }

                @Override // android.text.TextWatcher
                public void afterTextChanged(Editable editable) {
                    if (TopicDetailView.this.ggg != null) {
                        if (!TopicDetailView.this.ggg.cwg()) {
                            TopicDetailView.this.lk(false);
                        }
                        TopicDetailView.this.ggg.rL(false);
                    }
                }
            });
        }
    }

    public void lk(boolean z) {
        if (this.ggh != null && this.ggh.getText() != null) {
            int selectionEnd = this.ggh.getSelectionEnd();
            SpannableStringBuilder b = this.ggg.b(this.ggh.getText());
            if (b != null) {
                this.ggg.rL(true);
                this.ggh.setText(b);
                if (z && this.ggg.cwe() >= 0) {
                    this.ggh.requestFocus();
                    this.ggh.setSelection(this.ggg.cwe());
                } else {
                    this.ggh.setSelection(selectionEnd);
                }
                this.ggg.rK(this.ggg.cwe() >= 0);
            }
        }
    }

    public void buP() {
        if (bc.cE(getContext())) {
            this.gge.arS();
            setEditorTopViewAboveEditor();
        }
        if (this.mTopicDetailData != null) {
            TiebaStatic.log(new am("c13359").bT("topic_id", String.valueOf(this.mTopicDetailData.topicId)));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void tJ(int i) {
        this.ggi = i;
        this.ggd.setVisibility(0);
        if (i == 1) {
            this.ggd.setText(R.string.topic_detail_pk_support);
            al.k(this.ggd, R.drawable.topic_discuss_support_bg);
        } else if (i == 2) {
            this.ggd.setText(R.string.topic_detail_pk_oppose);
            al.k(this.ggd, R.drawable.topic_discuss_oppose_bg);
        } else {
            this.ggd.setText(R.string.topic_detail_pk_chigua);
            al.k(this.ggd, R.drawable.topic_discuss_opinion_bg);
        }
        if (this.mSkinType == 1) {
            this.ggd.setTextColor(-2130706433);
        } else {
            al.j(this.ggd, R.color.cp_btn_a);
        }
    }

    public void setData(com.baidu.tieba.homepage.topic.topicdetail.b.a aVar) {
        int g;
        if (aVar != null) {
            this.mTopicDetailData = aVar;
            this.mHasMore = this.mTopicDetailData.hasMore;
            if (this.mHasMore && this.mTopicDetailData.mDataList.size() <= 4) {
                this.mHasMore = false;
                aII();
            } else if (!this.mHasMore) {
                aII();
            } else {
                aIH();
            }
            if (!StringUtils.isNull(aVar.bHD)) {
                this.mNavigationBar.setCenterTextTitle(String.format(getContext().getString(R.string.daily_topic_name), ap.j(aVar.bHD, 14, "...")));
            }
            this.gfY.setData(aVar.gfo);
            this.fOt.addHeaderView(this.gfY);
            this.gfZ.setData(aVar.mDataList);
            if (this.mTopicDetailData.gfo.gft != null) {
                if (this.mTopicDetailData.gfo.gft.ggQ.ggW) {
                    tJ(1);
                } else if (this.mTopicDetailData.gfo.gft.ggR.ggW) {
                    tJ(2);
                } else {
                    tJ(0);
                }
                g = l.g(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds130);
            } else {
                g = l.g(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds50);
                this.ggd.setVisibility(8);
            }
            this.ggc.setPadding(g, 0, 0, 0);
            buQ();
        }
    }

    public void setNextData(int i, boolean z, List<m> list) {
        this.mHasMore = z;
        if (!this.mHasMore) {
            aII();
        } else {
            aIH();
        }
        if (i == 0 && list != null && !v.aa(list)) {
            for (m mVar : list) {
                if (mVar instanceof com.baidu.tieba.homepage.topic.topicdetail.b.c) {
                    ((com.baidu.tieba.homepage.topic.topicdetail.b.c) mVar).gfy = this.mTopicDetailData.buJ();
                }
            }
            this.mTopicDetailData.mDataList.addAll(list);
            this.fOt.setData(this.mTopicDetailData.mDataList);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aIJ() {
        this.fOt.setNextPage(null);
    }

    public void aIH() {
        this.mHasMore = true;
        this.fOt.setNextPage(this.dlY);
        this.dlY.ajy();
    }

    public void aII() {
        this.fOt.setNextPage(this.dlY);
        this.dlY.ajz();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.fqN) {
            this.mPageContext.getPageActivity().finish();
        } else if (view == this.gfX && this.mTopicDetailData != null && this.mTopicDetailData.topicId > 0) {
            ajT();
            TiebaStatic.log(new am("c13364").bT("topic_id", String.valueOf(this.mTopicDetailData.topicId)));
        }
    }

    private void ajT() {
        if (this.mTopicDetailData != null && getContext() != null) {
            String valueOf = String.valueOf(this.mTopicDetailData.topicId);
            String str = this.mTopicDetailData.bHD;
            String str2 = this.mTopicDetailData.shareTitle;
            if (TextUtils.isEmpty(valueOf) || TextUtils.isEmpty(str)) {
                this.mPageContext.showToast(getContext().getString(R.string.no_hot_topic_data));
                return;
            }
            String str3 = "http://tieba.baidu.com/mo/q/newtopic/detail?topic_id=" + valueOf + "/";
            Uri parse = StringUtils.isNull(this.mTopicDetailData.gfn) ? null : Uri.parse(this.mTopicDetailData.gfn);
            final com.baidu.tbadk.coreExtra.c.e eVar = new com.baidu.tbadk.coreExtra.c.e();
            eVar.title = str;
            eVar.content = str2;
            eVar.linkUrl = str3;
            eVar.cjt = true;
            eVar.extData = valueOf;
            eVar.imageUri = parse;
            ShareDialogConfig shareDialogConfig = new ShareDialogConfig(getContext(), eVar, true, true);
            shareDialogConfig.setIsCopyLink(true);
            shareDialogConfig.setCopyLinkListener(new View.OnClickListener() { // from class: com.baidu.tieba.homepage.topic.topicdetail.view.TopicDetailView.10
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    com.baidu.adp.lib.util.a.aR(eVar.linkUrl);
                    l.showToast(TopicDetailView.this.getContext(), view.getResources().getString(R.string.copy_pb_url_success));
                }
            });
            this.mPageContext.sendMessage(new CustomMessage(2001276, shareDialogConfig));
        }
    }

    public void onChangeSkinType() {
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        if (skinType != this.mSkinType) {
            this.mSkinType = skinType;
            buQ();
            al.j(this.mNavigationBar.mCenterText, R.color.cp_btn_a);
            al.k(this.ggb, R.color.cp_cont_g);
            al.j(this.ggc, R.color.cp_cont_d);
            al.k(this.ggc, R.drawable.topic_discuss_input_bg);
            tJ(this.ggi);
            al.c(this.mBackImageView, (int) R.drawable.icon_topbar_return_white_n, (int) R.drawable.icon_topbar_return_white_s);
            if (this.gfX != null) {
                al.c(this.gfX, (int) R.drawable.selector_topbar_share_white);
            }
            if (this.mPageContext != null && this.dlX != null) {
                this.dlX.onChangeSkinType(this.mPageContext, this.mSkinType);
            }
            if (this.dhY != null) {
                this.dhY.onChangeSkinType();
            }
            if (this.mRefreshView != null) {
                this.mRefreshView.onChangeSkinType();
            }
            if (this.gge != null && this.gge.aqS() != null) {
                this.gge.aqS().onChangeSkinType(this.mSkinType);
            }
            if (this.dlY != null) {
                this.dlY.iN(R.color.cp_cont_e);
                this.dlY.setTextColor(al.getColor(R.color.cp_cont_e));
                this.dlY.iO(al.getColor(R.color.cp_bg_line_d));
                this.dlY.iK(al.getColor(R.color.cp_bg_line_c));
            }
            if (this.gfY != null) {
                this.gfY.onChangeSkinType();
            }
            if (this.gfZ != null) {
                this.gfZ.notifyDataSetChanged();
            }
            al.l(this.fOt, R.color.cp_bg_line_d);
        }
    }

    public void cV(boolean z) {
        if (!beF()) {
            if (this.dhY == null) {
                this.dhY = new g(getContext());
                this.dhY.onChangeSkinType();
            }
            this.dhY.attachView(this, z);
        }
    }

    public void hideLoadingView() {
        if (this.dhY != null) {
            this.dhY.dettachView(this);
            this.dhY = null;
        }
    }

    public boolean beF() {
        if (this.dhY != null) {
            return this.dhY.isViewAttached();
        }
        return false;
    }

    public void jk(boolean z) {
        if (!beG()) {
            if (this.mRefreshView == null) {
                this.mRefreshView = new h(getContext(), new View.OnClickListener() { // from class: com.baidu.tieba.homepage.topic.topicdetail.view.TopicDetailView.2
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        if (j.jG() && TopicDetailView.this.gfW != null) {
                            TopicDetailView.this.gfW.loadData();
                        }
                    }
                });
            }
            this.mRefreshView.kE(this.mPageContext.getResources().getDimensionPixelSize(R.dimen.ds380));
            this.mRefreshView.attachView(this, z);
            this.mRefreshView.asB();
            this.fOt.setVisibility(8);
            al.c(this.mBackImageView, (int) R.drawable.icon_topbar_return_n, (int) R.drawable.icon_topbar_return_s);
        }
    }

    public void aHK() {
        if (this.mRefreshView != null) {
            this.mRefreshView.dettachView(this);
            this.mRefreshView = null;
        }
        this.fOt.setVisibility(0);
        al.c(this.mBackImageView, (int) R.drawable.icon_topbar_return_white_n, (int) R.drawable.icon_topbar_return_white_s);
    }

    public boolean beG() {
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
        this.fOt.setOnSrollToBottomListener(null);
        if (this.dlX != null) {
            this.dlX.b(this.eCl);
        }
        if (this.gge != null) {
            this.gge.onDestory();
        }
        if (this.ggk != null) {
            com.baidu.adp.lib.g.e.iB().removeCallbacks(this.ggk);
        }
        hideLoadingView();
        aHK();
    }

    public a getEditor() {
        return this.gge;
    }

    public void setEditorTopViewAboveEditor() {
        if (this.ggf != null) {
            ViewGroup.LayoutParams layoutParams = this.ggf.getLayoutParams();
            if (layoutParams instanceof RelativeLayout.LayoutParams) {
                RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) layoutParams;
                if (this.gge.aqS().isVisible()) {
                    layoutParams2.addRule(2, this.gge.aqS().getId());
                } else {
                    layoutParams2.addRule(2, this.gga.getId());
                }
                this.ggf.setLayoutParams(layoutParams2);
            }
        }
    }

    public void ar(bg bgVar) {
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
            cVar2.gfw = cVar.gfw;
            cVar2.threadData = bgVar;
            cVar2.source = 2;
            cVar2.gfx = this.ggi;
            cVar2.topicId = this.mTopicDetailData.topicId;
            cVar2.gfy = this.mTopicDetailData.buJ();
            this.mTopicDetailData.mDataList.add(i, cVar2);
            this.gfZ.setData(this.mTopicDetailData.mDataList);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void buQ() {
        if (this.mTopicDetailData != null && this.gfY != null) {
            if (this.ggl > this.ggm) {
                this.mNavigationBar.getBarBgView().setAlpha(1.0f);
                this.mNavigationBar.getBarBgView().setBackgroundDrawable(new BitmapDrawable(buR()));
                return;
            }
            al.l(this.mNavigationBar.getBarBgView(), R.color.transparent);
            this.mNavigationBar.getBarBgView().setAlpha(0.0f);
        }
    }

    public Bitmap buR() {
        Bitmap drawingCache;
        com.baidu.adp.widget.ImageView.a bdImage = this.gfY.getmBgImg().getBdImage();
        if (bdImage != null) {
            drawingCache = bdImage.ns();
        } else {
            drawingCache = this.gfY.getmBgImg().getDrawingCache();
        }
        int width = this.mPageContext.getPageActivity().getWindowManager().getDefaultDisplay().getWidth();
        int height = this.mNavigationBar.getHeight();
        if (drawingCache != null && drawingCache.getWidth() >= width && drawingCache.getHeight() >= height) {
            return Bitmap.createBitmap(drawingCache, 0, 0, width, height);
        }
        return drawingCache;
    }
}
