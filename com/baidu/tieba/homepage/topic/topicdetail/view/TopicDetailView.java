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
    private com.baidu.tbadk.editortools.pb.b csx;
    private g dhX;
    private NoNetworkView dlW;
    private PbListView dlX;
    private NoNetworkView.a eCk;
    private BdTypeRecyclerView fOq;
    private View fqM;
    private com.baidu.tieba.homepage.topic.topicdetail.a gfT;
    private ImageView gfU;
    private TopicDetailHeadView gfV;
    private com.baidu.tieba.homepage.topic.topicdetail.a.b gfW;
    private View gfX;
    private View gfY;
    private TextView gfZ;
    private TextView gga;
    private a ggb;
    private View ggc;
    private com.baidu.tieba.write.b ggd;
    private EditText gge;
    private int ggf;
    private com.baidu.tieba.homepage.topic.topicdetail.model.a ggg;
    a.RunnableC0322a ggh;
    private int ggi;
    private int ggj;
    private NewWriteModel.d ggk;
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
        this.gfY = null;
        this.gfZ = null;
        this.gga = null;
        this.mHasMore = true;
        this.ggi = 0;
        this.ggj = 44;
        this.eCk = new NoNetworkView.a() { // from class: com.baidu.tieba.homepage.topic.topicdetail.view.TopicDetailView.1
            @Override // com.baidu.tbadk.core.view.NoNetworkView.a
            public void el(boolean z) {
                if (z && TopicDetailView.this.mTopicDetailData == null && TopicDetailView.this.gfT != null) {
                    TopicDetailView.this.gfT.loadData();
                }
            }
        };
        this.csx = new com.baidu.tbadk.editortools.pb.b() { // from class: com.baidu.tieba.homepage.topic.topicdetail.view.TopicDetailView.6
            @Override // com.baidu.tbadk.editortools.pb.b
            public boolean arq() {
                if (TopicDetailView.this.ggd.cwe()) {
                    TopicDetailView.this.mPageContext.showToast(TopicDetailView.this.ggd.cwg());
                    TopicDetailView.this.lj(true);
                    return true;
                }
                return false;
            }
        };
        this.ggk = new NewWriteModel.d() { // from class: com.baidu.tieba.homepage.topic.topicdetail.view.TopicDetailView.7
            @Override // com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.d
            public void callback(boolean z, PostWriteCallBackData postWriteCallBackData, x xVar, WriteData writeData, AntiData antiData) {
                if (z && TopicDetailView.this.ggb != null && TopicDetailView.this.ggb.aqS() != null) {
                    TopicDetailView.this.ggb.aqS().hide();
                }
                if (z) {
                    TopicDetailView.this.ggd.FE(null);
                    TopicDetailView.this.ggd.aI(null);
                    TopicDetailView.this.ggd.rJ(false);
                    if (postWriteCallBackData != null) {
                        long c = com.baidu.adp.lib.g.b.c(postWriteCallBackData.getPostId(), 0L);
                        long c2 = com.baidu.adp.lib.g.b.c(postWriteCallBackData.getThreadId(), 0L);
                        if (c != 0 && c2 != 0) {
                            TopicDetailView.this.ggh = TopicDetailView.this.ggg.p(c, c2);
                            com.baidu.adp.lib.g.e.iB().postDelayed(TopicDetailView.this.ggh, 500L);
                        }
                    }
                } else if (postWriteCallBackData != null && postWriteCallBackData.isSensitiveError()) {
                    TopicDetailView.this.ggd.aI(postWriteCallBackData.getSensitiveWords());
                    TopicDetailView.this.ggd.FE(postWriteCallBackData.getErrorString());
                    if (!v.aa(TopicDetailView.this.ggd.cwc())) {
                        TopicDetailView.this.lj(true);
                    }
                }
            }
        };
        this.mScrollListener = new RecyclerView.OnScrollListener() { // from class: com.baidu.tieba.homepage.topic.topicdetail.view.TopicDetailView.8
            @Override // android.support.v7.widget.RecyclerView.OnScrollListener
            public void onScrollStateChanged(RecyclerView recyclerView, int i) {
                if (i != 0 && TopicDetailView.this.ggb != null) {
                    TopicDetailView.this.ggb.arP();
                    TopicDetailView.this.setEditorTopViewAboveEditor();
                }
                super.onScrollStateChanged(TopicDetailView.this.fOq, i);
            }

            @Override // android.support.v7.widget.RecyclerView.OnScrollListener
            public void onScrolled(RecyclerView recyclerView, int i, int i2) {
                super.onScrolled(recyclerView, i, i2);
                TopicDetailView.this.ggi += i2;
                TopicDetailView.this.buM();
            }
        };
        this.mOnScrollToBottomListener = new BdListView.e() { // from class: com.baidu.tieba.homepage.topic.topicdetail.view.TopicDetailView.9
            @Override // com.baidu.adp.widget.ListView.BdListView.e
            public void onScrollToBottom() {
                if (TopicDetailView.this.mHasMore) {
                    if (!l.ki()) {
                        TopicDetailView.this.aIG();
                        return;
                    }
                    int size = TopicDetailView.this.mTopicDetailData.mDataList.size();
                    if (TopicDetailView.this.mTopicDetailData.mDataList.get(size - 1) instanceof com.baidu.tieba.homepage.topic.topicdetail.b.c) {
                        ((TopicDetailActivity) TopicDetailView.this.mPageContext.getPageActivity()).dk(((com.baidu.tieba.homepage.topic.topicdetail.b.c) TopicDetailView.this.mTopicDetailData.mDataList.get(size - 1)).gft);
                    }
                }
            }
        };
        this.mPageContext = tbPageContext;
        this.gfT = aVar;
        init(bundle);
        onChangeSkinType();
    }

    private void init(Bundle bundle) {
        LayoutInflater.from(getContext()).inflate(R.layout.activity_topic_detail_layout, (ViewGroup) this, true);
        this.mNavigationBar = (NavigationBar) findViewById(R.id.activity_topic_detail_navigation);
        if (this.fqM == null) {
            this.fqM = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
            this.fqM.setOnClickListener(this);
            this.mBackImageView = (ImageView) this.fqM.findViewById(R.id.widget_navi_back_button);
        }
        this.gfU = (ImageView) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, R.layout.topic_detail_share_layout, this);
        al.c(this.gfU, (int) R.drawable.selector_topbar_share_white);
        al.j(this.mNavigationBar.mCenterText, R.color.cp_btn_a);
        this.mNavigationBar.mCenterText.setTextSize(0, getResources().getDimensionPixelSize(R.dimen.tbds52));
        this.mNavigationBar.mCenterText.setTypeface(Typeface.defaultFromStyle(1));
        this.dlW = (NoNetworkView) findViewById(R.id.activity_topic_detail_no_network_view);
        this.dlW.a(this.eCk);
        this.gfY = findViewById(R.id.pb_editor_tool_comment);
        this.gfZ = (TextView) findViewById(R.id.topic_editor_tool_comment_reply_text);
        this.gfZ.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.homepage.topic.topicdetail.view.TopicDetailView.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                TopicDetailView.this.buL();
            }
        });
        this.gga = (TextView) findViewById(R.id.editor_tool_opinion_text_view);
        this.gfX = findViewById(R.id.activity_topic_detail_editor);
        S(bundle);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
        layoutParams.addRule(12);
        addView(this.ggb.aqS(), layoutParams);
        this.ggd = new com.baidu.tieba.write.b();
        this.ggc = findViewById(R.id.activity_topic_detail_editor_top);
        this.fOq = (BdTypeRecyclerView) findViewById(R.id.activity_topic_detail_list);
        this.fOq.setLayoutManager(new LinearLayoutManager(getContext()));
        this.fOq.setFadingEdgeLength(0);
        this.fOq.setOverScrollMode(2);
        this.fOq.setOnSrollToBottomListener(this.mOnScrollToBottomListener);
        this.fOq.addOnScrollListener(this.mScrollListener);
        al.l(this.fOq, R.color.cp_bg_line_d);
        this.gfW = new com.baidu.tieba.homepage.topic.topicdetail.a.b(this.mPageContext, this.fOq);
        this.gfV = new TopicDetailHeadView(getContext());
        this.gfV.gfR.setPkClickListener(new TopicPkView.b() { // from class: com.baidu.tieba.homepage.topic.topicdetail.view.TopicDetailView.4
            @Override // com.baidu.tieba.homepage.topic.topictab.view.TopicPkView.b
            public void tK(int i) {
                TopicDetailView.this.tJ(i);
            }
        });
        if (this.dhX == null) {
            this.dlX = new PbListView(this.mPageContext.getPageActivity());
            this.dlX.getView();
        }
        this.dlX.iO(R.color.cp_bg_line_e);
        this.dlX.setHeight(l.g(this.mPageContext.getPageActivity(), R.dimen.tbds182));
        this.dlX.setTextSize(R.dimen.tbfontsize33);
        this.dlX.iN(R.color.cp_cont_e);
        this.dlX.setTextColor(al.getColor(R.color.cp_cont_e));
        this.dlX.iO(al.getColor(R.color.cp_bg_line_d));
        this.dlX.iK(al.getColor(R.color.cp_bg_line_c));
        this.dlX.setText(getResources().getString(R.string.list_has_no_more));
        this.dlX.getView().setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
        if (this.ggg == null) {
            this.ggg = new com.baidu.tieba.homepage.topic.topicdetail.model.a(this);
            this.ggg.i(this.mPageContext.getUniqueId());
        }
    }

    private void S(Bundle bundle) {
        this.ggb = (a) new b().cJ(getContext());
        if (this.ggb != null) {
            this.ggb.a(this.mPageContext);
            this.ggb.b(this.ggk);
            this.ggb.a(this.csx);
            this.ggb.aqS().fd(true);
            this.ggb.a((BaseActivity) getContext(), bundle);
            this.ggb.arP();
            this.ggb.aqS().setId(R.id.topic_editor);
            this.gge = this.ggb.buK().getInputView();
            this.gge.addTextChangedListener(new TextWatcher() { // from class: com.baidu.tieba.homepage.topic.topicdetail.view.TopicDetailView.5
                @Override // android.text.TextWatcher
                public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                }

                @Override // android.text.TextWatcher
                public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                }

                @Override // android.text.TextWatcher
                public void afterTextChanged(Editable editable) {
                    if (TopicDetailView.this.ggd != null) {
                        if (!TopicDetailView.this.ggd.cwf()) {
                            TopicDetailView.this.lj(false);
                        }
                        TopicDetailView.this.ggd.rK(false);
                    }
                }
            });
        }
    }

    public void lj(boolean z) {
        if (this.gge != null && this.gge.getText() != null) {
            int selectionEnd = this.gge.getSelectionEnd();
            SpannableStringBuilder b = this.ggd.b(this.gge.getText());
            if (b != null) {
                this.ggd.rK(true);
                this.gge.setText(b);
                if (z && this.ggd.cwd() >= 0) {
                    this.gge.requestFocus();
                    this.gge.setSelection(this.ggd.cwd());
                } else {
                    this.gge.setSelection(selectionEnd);
                }
                this.ggd.rJ(this.ggd.cwd() >= 0);
            }
        }
    }

    public void buL() {
        if (bc.cE(getContext())) {
            this.ggb.arS();
            setEditorTopViewAboveEditor();
        }
        if (this.mTopicDetailData != null) {
            TiebaStatic.log(new am("c13359").bT("topic_id", String.valueOf(this.mTopicDetailData.topicId)));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void tJ(int i) {
        this.ggf = i;
        this.gga.setVisibility(0);
        if (i == 1) {
            this.gga.setText(R.string.topic_detail_pk_support);
            al.k(this.gga, R.drawable.topic_discuss_support_bg);
        } else if (i == 2) {
            this.gga.setText(R.string.topic_detail_pk_oppose);
            al.k(this.gga, R.drawable.topic_discuss_oppose_bg);
        } else {
            this.gga.setText(R.string.topic_detail_pk_chigua);
            al.k(this.gga, R.drawable.topic_discuss_opinion_bg);
        }
        if (this.mSkinType == 1) {
            this.gga.setTextColor(-2130706433);
        } else {
            al.j(this.gga, R.color.cp_btn_a);
        }
    }

    public void setData(com.baidu.tieba.homepage.topic.topicdetail.b.a aVar) {
        int g;
        if (aVar != null) {
            this.mTopicDetailData = aVar;
            this.mHasMore = this.mTopicDetailData.hasMore;
            if (this.mHasMore && this.mTopicDetailData.mDataList.size() <= 4) {
                this.mHasMore = false;
                aIF();
            } else if (!this.mHasMore) {
                aIF();
            } else {
                aIE();
            }
            if (!StringUtils.isNull(aVar.bHC)) {
                this.mNavigationBar.setCenterTextTitle(String.format(getContext().getString(R.string.daily_topic_name), ap.j(aVar.bHC, 14, "...")));
            }
            this.gfV.setData(aVar.gfl);
            this.fOq.addHeaderView(this.gfV);
            this.gfW.setData(aVar.mDataList);
            if (this.mTopicDetailData.gfl.gfq != null) {
                if (this.mTopicDetailData.gfl.gfq.ggN.ggT) {
                    tJ(1);
                } else if (this.mTopicDetailData.gfl.gfq.ggO.ggT) {
                    tJ(2);
                } else {
                    tJ(0);
                }
                g = l.g(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds130);
            } else {
                g = l.g(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds50);
                this.gga.setVisibility(8);
            }
            this.gfZ.setPadding(g, 0, 0, 0);
            buM();
        }
    }

    public void setNextData(int i, boolean z, List<m> list) {
        this.mHasMore = z;
        if (!this.mHasMore) {
            aIF();
        } else {
            aIE();
        }
        if (i == 0 && list != null && !v.aa(list)) {
            for (m mVar : list) {
                if (mVar instanceof com.baidu.tieba.homepage.topic.topicdetail.b.c) {
                    ((com.baidu.tieba.homepage.topic.topicdetail.b.c) mVar).gfv = this.mTopicDetailData.buF();
                }
            }
            this.mTopicDetailData.mDataList.addAll(list);
            this.fOq.setData(this.mTopicDetailData.mDataList);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aIG() {
        this.fOq.setNextPage(null);
    }

    public void aIE() {
        this.mHasMore = true;
        this.fOq.setNextPage(this.dlX);
        this.dlX.ajy();
    }

    public void aIF() {
        this.fOq.setNextPage(this.dlX);
        this.dlX.ajz();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.fqM) {
            this.mPageContext.getPageActivity().finish();
        } else if (view == this.gfU && this.mTopicDetailData != null && this.mTopicDetailData.topicId > 0) {
            ajT();
            TiebaStatic.log(new am("c13364").bT("topic_id", String.valueOf(this.mTopicDetailData.topicId)));
        }
    }

    private void ajT() {
        if (this.mTopicDetailData != null && getContext() != null) {
            String valueOf = String.valueOf(this.mTopicDetailData.topicId);
            String str = this.mTopicDetailData.bHC;
            String str2 = this.mTopicDetailData.shareTitle;
            if (TextUtils.isEmpty(valueOf) || TextUtils.isEmpty(str)) {
                this.mPageContext.showToast(getContext().getString(R.string.no_hot_topic_data));
                return;
            }
            String str3 = "http://tieba.baidu.com/mo/q/newtopic/detail?topic_id=" + valueOf + "/";
            Uri parse = StringUtils.isNull(this.mTopicDetailData.gfk) ? null : Uri.parse(this.mTopicDetailData.gfk);
            final com.baidu.tbadk.coreExtra.c.e eVar = new com.baidu.tbadk.coreExtra.c.e();
            eVar.title = str;
            eVar.content = str2;
            eVar.linkUrl = str3;
            eVar.cjs = true;
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
            buM();
            al.j(this.mNavigationBar.mCenterText, R.color.cp_btn_a);
            al.k(this.gfY, R.color.cp_cont_g);
            al.j(this.gfZ, R.color.cp_cont_d);
            al.k(this.gfZ, R.drawable.topic_discuss_input_bg);
            tJ(this.ggf);
            al.c(this.mBackImageView, (int) R.drawable.icon_topbar_return_white_n, (int) R.drawable.icon_topbar_return_white_s);
            if (this.gfU != null) {
                al.c(this.gfU, (int) R.drawable.selector_topbar_share_white);
            }
            if (this.mPageContext != null && this.dlW != null) {
                this.dlW.onChangeSkinType(this.mPageContext, this.mSkinType);
            }
            if (this.dhX != null) {
                this.dhX.onChangeSkinType();
            }
            if (this.mRefreshView != null) {
                this.mRefreshView.onChangeSkinType();
            }
            if (this.ggb != null && this.ggb.aqS() != null) {
                this.ggb.aqS().onChangeSkinType(this.mSkinType);
            }
            if (this.dlX != null) {
                this.dlX.iN(R.color.cp_cont_e);
                this.dlX.setTextColor(al.getColor(R.color.cp_cont_e));
                this.dlX.iO(al.getColor(R.color.cp_bg_line_d));
                this.dlX.iK(al.getColor(R.color.cp_bg_line_c));
            }
            if (this.gfV != null) {
                this.gfV.onChangeSkinType();
            }
            if (this.gfW != null) {
                this.gfW.notifyDataSetChanged();
            }
            al.l(this.fOq, R.color.cp_bg_line_d);
        }
    }

    public void cV(boolean z) {
        if (!beC()) {
            if (this.dhX == null) {
                this.dhX = new g(getContext());
                this.dhX.onChangeSkinType();
            }
            this.dhX.attachView(this, z);
        }
    }

    public void hideLoadingView() {
        if (this.dhX != null) {
            this.dhX.dettachView(this);
            this.dhX = null;
        }
    }

    public boolean beC() {
        if (this.dhX != null) {
            return this.dhX.isViewAttached();
        }
        return false;
    }

    public void jk(boolean z) {
        if (!beD()) {
            if (this.mRefreshView == null) {
                this.mRefreshView = new h(getContext(), new View.OnClickListener() { // from class: com.baidu.tieba.homepage.topic.topicdetail.view.TopicDetailView.2
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        if (j.jG() && TopicDetailView.this.gfT != null) {
                            TopicDetailView.this.gfT.loadData();
                        }
                    }
                });
            }
            this.mRefreshView.kE(this.mPageContext.getResources().getDimensionPixelSize(R.dimen.ds380));
            this.mRefreshView.attachView(this, z);
            this.mRefreshView.asB();
            this.fOq.setVisibility(8);
            al.c(this.mBackImageView, (int) R.drawable.icon_topbar_return_n, (int) R.drawable.icon_topbar_return_s);
        }
    }

    public void aHH() {
        if (this.mRefreshView != null) {
            this.mRefreshView.dettachView(this);
            this.mRefreshView = null;
        }
        this.fOq.setVisibility(0);
        al.c(this.mBackImageView, (int) R.drawable.icon_topbar_return_white_n, (int) R.drawable.icon_topbar_return_white_s);
    }

    public boolean beD() {
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
        this.fOq.setOnSrollToBottomListener(null);
        if (this.dlW != null) {
            this.dlW.b(this.eCk);
        }
        if (this.ggb != null) {
            this.ggb.onDestory();
        }
        if (this.ggh != null) {
            com.baidu.adp.lib.g.e.iB().removeCallbacks(this.ggh);
        }
        hideLoadingView();
        aHH();
    }

    public a getEditor() {
        return this.ggb;
    }

    public void setEditorTopViewAboveEditor() {
        if (this.ggc != null) {
            ViewGroup.LayoutParams layoutParams = this.ggc.getLayoutParams();
            if (layoutParams instanceof RelativeLayout.LayoutParams) {
                RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) layoutParams;
                if (this.ggb.aqS().isVisible()) {
                    layoutParams2.addRule(2, this.ggb.aqS().getId());
                } else {
                    layoutParams2.addRule(2, this.gfX.getId());
                }
                this.ggc.setLayoutParams(layoutParams2);
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
            cVar2.gft = cVar.gft;
            cVar2.threadData = bgVar;
            cVar2.source = 2;
            cVar2.gfu = this.ggf;
            cVar2.topicId = this.mTopicDetailData.topicId;
            cVar2.gfv = this.mTopicDetailData.buF();
            this.mTopicDetailData.mDataList.add(i, cVar2);
            this.gfW.setData(this.mTopicDetailData.mDataList);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void buM() {
        if (this.mTopicDetailData != null && this.gfV != null) {
            if (this.ggi > this.ggj) {
                this.mNavigationBar.getBarBgView().setAlpha(1.0f);
                this.mNavigationBar.getBarBgView().setBackgroundDrawable(new BitmapDrawable(buN()));
                return;
            }
            al.l(this.mNavigationBar.getBarBgView(), R.color.transparent);
            this.mNavigationBar.getBarBgView().setAlpha(0.0f);
        }
    }

    public Bitmap buN() {
        Bitmap drawingCache;
        com.baidu.adp.widget.ImageView.a bdImage = this.gfV.getmBgImg().getBdImage();
        if (bdImage != null) {
            drawingCache = bdImage.ns();
        } else {
            drawingCache = this.gfV.getmBgImg().getDrawingCache();
        }
        int width = this.mPageContext.getPageActivity().getWindowManager().getDefaultDisplay().getWidth();
        int height = this.mNavigationBar.getHeight();
        if (drawingCache != null && drawingCache.getWidth() >= width && drawingCache.getHeight() >= height) {
            return Bitmap.createBitmap(drawingCache, 0, 0, width, height);
        }
        return drawingCache;
    }
}
