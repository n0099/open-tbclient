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
import com.baidu.adp.widget.ListView.q;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.live.tbadk.core.util.StringHelper;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.ShareDialogConfig;
import com.baidu.tbadk.core.data.AntiData;
import com.baidu.tbadk.core.data.bw;
import com.baidu.tbadk.core.util.SvgManager;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.util.at;
import com.baidu.tbadk.core.util.bg;
import com.baidu.tbadk.core.util.y;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tbadk.core.view.PbListView;
import com.baidu.tbadk.coreExtra.data.WriteData;
import com.baidu.tbadk.coreExtra.data.ah;
import com.baidu.tbadk.coreExtra.share.ShareItem;
import com.baidu.tbadk.k.g;
import com.baidu.tbadk.k.h;
import com.baidu.tieba.R;
import com.baidu.tieba.homepage.topic.topicdetail.TopicDetailActivity;
import com.baidu.tieba.homepage.topic.topicdetail.model.a;
import com.baidu.tieba.homepage.topic.topictab.view.TopicPkView;
import com.baidu.tieba.tbadkCore.writeModel.NewWriteModel;
import com.baidu.tieba.tbadkCore.writeModel.PostWriteCallBackData;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes22.dex */
public class TopicDetailView extends RelativeLayout implements View.OnClickListener {
    private BdListView.e VQ;
    private NoNetworkView.a fRO;
    private NoNetworkView fTu;
    private PbListView fTv;
    private com.baidu.tbadk.editortools.pb.b fbz;
    private g gcx;
    private BdTypeRecyclerView iSZ;
    private View irv;
    private ImageView jrA;
    private TopicDetailHeadView jrB;
    private com.baidu.tieba.homepage.topic.topicdetail.a.b jrC;
    private View jrD;
    private View jrE;
    private TextView jrF;
    private TextView jrG;
    private a jrH;
    private View jrI;
    private com.baidu.tieba.write.c jrJ;
    private EditText jrK;
    private int jrL;
    private com.baidu.tieba.homepage.topic.topicdetail.model.a jrM;
    a.RunnableC0716a jrN;
    private int jrO;
    private int jrP;
    private NewWriteModel.d jrQ;
    private com.baidu.tieba.homepage.topic.topicdetail.a jrz;
    private ImageView mBackImageView;
    private boolean mHasMore;
    private NavigationBar mNavigationBar;
    private TbPageContext<?> mPageContext;
    private h mRefreshView;
    private final RecyclerView.OnScrollListener mScrollListener;
    private int mSkinType;
    private com.baidu.tieba.homepage.topic.topicdetail.b.a mTopicDetailData;

    public TopicDetailView(TbPageContext<?> tbPageContext, com.baidu.tieba.homepage.topic.topicdetail.a aVar, Bundle bundle) {
        super(tbPageContext.getPageActivity());
        this.mSkinType = 3;
        this.jrE = null;
        this.jrF = null;
        this.jrG = null;
        this.mHasMore = true;
        this.jrO = 0;
        this.jrP = 44;
        this.fRO = new NoNetworkView.a() { // from class: com.baidu.tieba.homepage.topic.topicdetail.view.TopicDetailView.1
            @Override // com.baidu.tbadk.core.view.NoNetworkView.a
            public void onNetworkChange(boolean z) {
                if (z && TopicDetailView.this.mTopicDetailData == null && TopicDetailView.this.jrz != null) {
                    TopicDetailView.this.jrz.loadData();
                }
            }
        };
        this.fbz = new com.baidu.tbadk.editortools.pb.b() { // from class: com.baidu.tieba.homepage.topic.topicdetail.view.TopicDetailView.6
            @Override // com.baidu.tbadk.editortools.pb.b
            public boolean bvJ() {
                if (TopicDetailView.this.jrJ.dNl()) {
                    TopicDetailView.this.mPageContext.showToast(TopicDetailView.this.jrJ.dNn());
                    TopicDetailView.this.qG(true);
                    return true;
                }
                return false;
            }
        };
        this.jrQ = new NewWriteModel.d() { // from class: com.baidu.tieba.homepage.topic.topicdetail.view.TopicDetailView.7
            @Override // com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.d
            public void callback(boolean z, PostWriteCallBackData postWriteCallBackData, ah ahVar, WriteData writeData, AntiData antiData) {
                if (z && TopicDetailView.this.jrH != null && TopicDetailView.this.jrH.bvf() != null) {
                    TopicDetailView.this.jrH.bvf().hide();
                }
                if (z) {
                    TopicDetailView.this.jrJ.TK(null);
                    TopicDetailView.this.jrJ.bh(null);
                    TopicDetailView.this.jrJ.xP(false);
                    if (postWriteCallBackData != null) {
                        long j = com.baidu.adp.lib.f.b.toLong(postWriteCallBackData.getPostId(), 0L);
                        long j2 = com.baidu.adp.lib.f.b.toLong(postWriteCallBackData.getThreadId(), 0L);
                        if (j != 0 && j2 != 0) {
                            TopicDetailView.this.jrN = TopicDetailView.this.jrM.y(j, j2);
                            com.baidu.adp.lib.f.e.mY().postDelayed(TopicDetailView.this.jrN, 500L);
                        }
                    }
                } else if (postWriteCallBackData != null && postWriteCallBackData.isSensitiveError()) {
                    TopicDetailView.this.jrJ.bh(postWriteCallBackData.getSensitiveWords());
                    TopicDetailView.this.jrJ.TK(postWriteCallBackData.getErrorString());
                    if (!y.isEmpty(TopicDetailView.this.jrJ.dNj())) {
                        TopicDetailView.this.qG(true);
                    }
                }
            }
        };
        this.mScrollListener = new RecyclerView.OnScrollListener() { // from class: com.baidu.tieba.homepage.topic.topicdetail.view.TopicDetailView.8
            @Override // android.support.v7.widget.RecyclerView.OnScrollListener
            public void onScrollStateChanged(RecyclerView recyclerView, int i) {
                if (i != 0 && TopicDetailView.this.jrH != null) {
                    TopicDetailView.this.jrH.bwn();
                    TopicDetailView.this.setEditorTopViewAboveEditor();
                }
                super.onScrollStateChanged(TopicDetailView.this.iSZ, i);
            }

            @Override // android.support.v7.widget.RecyclerView.OnScrollListener
            public void onScrolled(RecyclerView recyclerView, int i, int i2) {
                super.onScrolled(recyclerView, i, i2);
                TopicDetailView.this.jrO += i2;
                TopicDetailView.this.cGv();
            }
        };
        this.VQ = new BdListView.e() { // from class: com.baidu.tieba.homepage.topic.topicdetail.view.TopicDetailView.9
            @Override // com.baidu.adp.widget.ListView.BdListView.e
            public void onScrollToBottom() {
                if (TopicDetailView.this.mHasMore) {
                    if (!l.isNetOk()) {
                        TopicDetailView.this.bKU();
                        return;
                    }
                    int size = TopicDetailView.this.mTopicDetailData.mDataList.size();
                    if (TopicDetailView.this.mTopicDetailData.mDataList.get(size - 1) instanceof com.baidu.tieba.homepage.topic.topicdetail.b.c) {
                        ((TopicDetailActivity) TopicDetailView.this.mPageContext.getPageActivity()).fx(((com.baidu.tieba.homepage.topic.topicdetail.b.c) TopicDetailView.this.mTopicDetailData.mDataList.get(size - 1)).jrb);
                    }
                }
            }
        };
        this.mPageContext = tbPageContext;
        this.jrz = aVar;
        init(bundle);
        onChangeSkinType();
    }

    private void init(Bundle bundle) {
        LayoutInflater.from(getContext()).inflate(R.layout.activity_topic_detail_layout, (ViewGroup) this, true);
        this.mNavigationBar = (NavigationBar) findViewById(R.id.activity_topic_detail_navigation);
        if (this.irv == null) {
            this.irv = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
            this.irv.setOnClickListener(this);
            this.mBackImageView = (ImageView) this.irv.findViewById(R.id.widget_navi_back_button);
        }
        this.jrA = (ImageView) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, R.layout.topic_detail_share_layout, this);
        SvgManager.bmU().a(this.jrA, R.drawable.icon_pure_topbar_share44_svg, R.color.white_alpha100, SvgManager.SvgResourceStateType.NORMAL_PRESS);
        ap.setViewTextColor(this.mNavigationBar.mCenterText, R.color.cp_cont_a);
        this.mNavigationBar.mCenterText.setTextSize(0, getResources().getDimensionPixelSize(R.dimen.tbds52));
        this.mNavigationBar.mCenterText.setTypeface(Typeface.defaultFromStyle(1));
        this.fTu = (NoNetworkView) findViewById(R.id.activity_topic_detail_no_network_view);
        this.fTu.a(this.fRO);
        this.jrE = findViewById(R.id.pb_editor_tool_comment);
        this.jrF = (TextView) findViewById(R.id.topic_editor_tool_comment_reply_text);
        this.jrF.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.homepage.topic.topicdetail.view.TopicDetailView.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                TopicDetailView.this.cGu();
            }
        });
        this.jrG = (TextView) findViewById(R.id.editor_tool_opinion_text_view);
        this.jrD = findViewById(R.id.activity_topic_detail_editor);
        ar(bundle);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
        layoutParams.addRule(12);
        addView(this.jrH.bvf(), layoutParams);
        this.jrJ = new com.baidu.tieba.write.c();
        this.jrI = findViewById(R.id.activity_topic_detail_editor_top);
        this.iSZ = (BdTypeRecyclerView) findViewById(R.id.activity_topic_detail_list);
        this.iSZ.setLayoutManager(new LinearLayoutManager(getContext()));
        this.iSZ.setFadingEdgeLength(0);
        this.iSZ.setOverScrollMode(2);
        this.iSZ.setOnSrollToBottomListener(this.VQ);
        this.iSZ.addOnScrollListener(this.mScrollListener);
        ap.setBackgroundColor(this.iSZ, R.color.cp_bg_line_d);
        this.jrC = new com.baidu.tieba.homepage.topic.topicdetail.a.b(this.mPageContext, this.iSZ);
        this.jrB = new TopicDetailHeadView(getContext());
        this.jrB.jrx.setPkClickListener(new TopicPkView.b() { // from class: com.baidu.tieba.homepage.topic.topicdetail.view.TopicDetailView.4
            @Override // com.baidu.tieba.homepage.topic.topictab.view.TopicPkView.b
            public void Bm(int i) {
                TopicDetailView.this.Bl(i);
            }
        });
        if (this.gcx == null) {
            this.fTv = new PbListView(this.mPageContext.getPageActivity());
            this.fTv.getView();
        }
        this.fTv.setContainerBackgroundColorResId(R.color.cp_bg_line_e);
        this.fTv.setHeight(l.getDimens(this.mPageContext.getPageActivity(), R.dimen.tbds182));
        this.fTv.setTextSize(R.dimen.tbfontsize33);
        this.fTv.setNoMoreTextColorId(R.color.cp_cont_e);
        this.fTv.setTextColor(ap.getColor(R.color.cp_cont_e));
        this.fTv.setContainerBackgroundColorResId(ap.getColor(R.color.cp_bg_line_d));
        this.fTv.setLineColorResource(ap.getColor(R.color.cp_bg_line_c));
        this.fTv.setText(getResources().getString(R.string.list_has_no_more));
        this.fTv.getView().setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
        if (this.jrM == null) {
            this.jrM = new com.baidu.tieba.homepage.topic.topicdetail.model.a(this);
            this.jrM.l(this.mPageContext.getUniqueId());
        }
    }

    private void ar(Bundle bundle) {
        this.jrH = (a) new b().ei(getContext());
        if (this.jrH != null) {
            this.jrH.a(this.mPageContext);
            this.jrH.b(this.jrQ);
            this.jrH.a(this.fbz);
            this.jrH.bvf().jF(true);
            this.jrH.bvf().setBarBackgroundColorId(R.color.cp_bg_line_h);
            this.jrH.a((BaseActivity) getContext(), bundle);
            this.jrH.bwn();
            this.jrH.bvf().setId(R.id.topic_editor);
            this.jrK = this.jrH.cGt().getInputView();
            this.jrK.addTextChangedListener(new TextWatcher() { // from class: com.baidu.tieba.homepage.topic.topicdetail.view.TopicDetailView.5
                @Override // android.text.TextWatcher
                public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                }

                @Override // android.text.TextWatcher
                public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                }

                @Override // android.text.TextWatcher
                public void afterTextChanged(Editable editable) {
                    if (TopicDetailView.this.jrJ != null) {
                        if (!TopicDetailView.this.jrJ.dNm()) {
                            TopicDetailView.this.qG(false);
                        }
                        TopicDetailView.this.jrJ.xQ(false);
                    }
                }
            });
        }
    }

    public void qG(boolean z) {
        if (this.jrK != null && this.jrK.getText() != null) {
            int selectionEnd = this.jrK.getSelectionEnd();
            SpannableStringBuilder c = this.jrJ.c(this.jrK.getText());
            if (c != null) {
                this.jrJ.xQ(true);
                this.jrK.setText(c);
                if (z && this.jrJ.dNk() >= 0) {
                    this.jrK.requestFocus();
                    this.jrK.setSelection(this.jrJ.dNk());
                } else {
                    this.jrK.setSelection(selectionEnd);
                }
                this.jrJ.xP(this.jrJ.dNk() >= 0);
            }
        }
    }

    public void cGu() {
        if (bg.checkUpIsLogin(getContext())) {
            this.jrH.bwq();
            setEditorTopViewAboveEditor();
        }
        if (this.mTopicDetailData != null) {
            TiebaStatic.log(new aq("c13359").dK("topic_id", String.valueOf(this.mTopicDetailData.topicId)));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Bl(int i) {
        this.jrL = i;
        this.jrG.setVisibility(0);
        if (i == 1) {
            this.jrG.setText(R.string.topic_detail_pk_support);
            ap.setBackgroundResource(this.jrG, R.drawable.topic_discuss_support_bg);
        } else if (i == 2) {
            this.jrG.setText(R.string.topic_detail_pk_oppose);
            ap.setBackgroundResource(this.jrG, R.drawable.topic_discuss_oppose_bg);
        } else {
            this.jrG.setText(R.string.topic_detail_pk_chigua);
            ap.setBackgroundResource(this.jrG, R.drawable.topic_discuss_opinion_bg);
        }
        if (this.mSkinType == 1 || this.mSkinType == 4) {
            this.jrG.setTextColor(-2130706433);
        } else {
            ap.setViewTextColor(this.jrG, R.color.cp_cont_a);
        }
    }

    public void setData(com.baidu.tieba.homepage.topic.topicdetail.b.a aVar) {
        int dimens;
        if (aVar != null) {
            this.mTopicDetailData = aVar;
            this.mHasMore = this.mTopicDetailData.hasMore;
            if (this.mHasMore && this.mTopicDetailData.mDataList.size() <= 4) {
                this.mHasMore = false;
                SJ();
            } else if (!this.mHasMore) {
                SJ();
            } else {
                SI();
            }
            if (!StringUtils.isNull(aVar.eou)) {
                this.mNavigationBar.setCenterTextTitle(String.format(getContext().getString(R.string.daily_topic_name), at.cutChineseAndEnglishWithSuffix(aVar.eou, 14, StringHelper.STRING_MORE)));
            }
            this.jrB.setData(aVar.jqT);
            this.iSZ.addHeaderView(this.jrB);
            this.jrC.setData(aVar.mDataList);
            if (this.mTopicDetailData.jqT.jqY != null) {
                if (this.mTopicDetailData.jqT.jqY.jss.jsy) {
                    Bl(1);
                } else if (this.mTopicDetailData.jqT.jqY.jst.jsy) {
                    Bl(2);
                } else {
                    Bl(0);
                }
                dimens = l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds140);
            } else {
                dimens = l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds50);
                this.jrG.setVisibility(8);
            }
            this.jrF.setPadding(dimens, 0, 0, 0);
            cGv();
        }
    }

    public void setNextData(int i, boolean z, List<q> list) {
        this.mHasMore = z;
        if (!this.mHasMore) {
            SJ();
        } else {
            SI();
        }
        if (i == 0 && list != null && !y.isEmpty(list)) {
            for (q qVar : list) {
                if (qVar instanceof com.baidu.tieba.homepage.topic.topicdetail.b.c) {
                    ((com.baidu.tieba.homepage.topic.topicdetail.b.c) qVar).jrd = this.mTopicDetailData.cGp();
                }
            }
            this.mTopicDetailData.mDataList.addAll(list);
            this.iSZ.setData(this.mTopicDetailData.mDataList);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bKU() {
        this.iSZ.setNextPage(null);
    }

    public void SI() {
        this.mHasMore = true;
        this.iSZ.setNextPage(this.fTv);
        this.fTv.startLoadData();
    }

    public void SJ() {
        this.iSZ.setNextPage(this.fTv);
        this.fTv.endLoadData();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.irv) {
            this.mPageContext.getPageActivity().finish();
        } else if (view == this.jrA && this.mTopicDetailData != null && this.mTopicDetailData.topicId > 0) {
            boA();
            TiebaStatic.log(new aq("c13364").dK("topic_id", String.valueOf(this.mTopicDetailData.topicId)));
        }
    }

    private void boA() {
        if (this.mTopicDetailData != null && getContext() != null) {
            String valueOf = String.valueOf(this.mTopicDetailData.topicId);
            String str = this.mTopicDetailData.eou;
            String str2 = this.mTopicDetailData.shareTitle;
            if (TextUtils.isEmpty(valueOf) || TextUtils.isEmpty(str)) {
                this.mPageContext.showToast(getContext().getString(R.string.no_hot_topic_data));
                return;
            }
            String str3 = "http://tieba.baidu.com/mo/q/newtopic/detail?topic_id=" + valueOf + "/";
            Uri parse = StringUtils.isNull(this.mTopicDetailData.jqS) ? null : Uri.parse(this.mTopicDetailData.jqS);
            final ShareItem shareItem = new ShareItem();
            shareItem.title = str;
            shareItem.content = str2;
            shareItem.linkUrl = str3;
            shareItem.eSz = true;
            shareItem.extData = valueOf;
            shareItem.imageUri = parse;
            ShareDialogConfig shareDialogConfig = new ShareDialogConfig(getContext(), shareItem, true, true);
            shareDialogConfig.setIsCopyLink(true);
            shareDialogConfig.setCopyLinkListener(new View.OnClickListener() { // from class: com.baidu.tieba.homepage.topic.topicdetail.view.TopicDetailView.10
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    com.baidu.adp.lib.util.a.copyToClipboard(shareItem.linkUrl);
                    l.showToast(TopicDetailView.this.getContext(), view.getResources().getString(R.string.copy_pb_url_success));
                }
            });
            this.mPageContext.sendMessage(new CustomMessage((int) CmdConfigCustom.CMD_SHARE_DIALOG_SHOW, shareDialogConfig));
        }
    }

    public void onChangeSkinType() {
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        if (skinType != this.mSkinType) {
            this.mSkinType = skinType;
            cGv();
            ap.setViewTextColor(this.mNavigationBar.mCenterText, R.color.cp_cont_a);
            ap.setBackgroundResource(this.jrE, R.color.cp_bg_line_h);
            ap.setViewTextColor(this.jrF, R.color.cp_cont_d);
            this.jrF.setBackgroundDrawable(ap.aN(l.getDimens(this.mPageContext.getPageActivity(), R.dimen.tbds47), ap.getColor(R.color.cp_bg_line_j)));
            Bl(this.jrL);
            SvgManager.bmU().a(this.mBackImageView, R.drawable.icon_pure_topbar_return44_svg, R.color.white_alpha100, SvgManager.SvgResourceStateType.NORMAL_PRESS);
            if (this.jrA != null) {
                SvgManager.bmU().a(this.jrA, R.drawable.icon_pure_topbar_share44_svg, R.color.white_alpha100, SvgManager.SvgResourceStateType.NORMAL_PRESS);
            }
            if (this.mPageContext != null && this.fTu != null) {
                this.fTu.onChangeSkinType(this.mPageContext, this.mSkinType);
            }
            if (this.gcx != null) {
                this.gcx.onChangeSkinType();
            }
            if (this.mRefreshView != null) {
                this.mRefreshView.onChangeSkinType();
            }
            if (this.jrH != null && this.jrH.bvf() != null) {
                this.jrH.bvf().onChangeSkinType(this.mSkinType);
            }
            if (this.fTv != null) {
                this.fTv.setNoMoreTextColorId(R.color.cp_cont_e);
                this.fTv.setTextColor(ap.getColor(R.color.cp_cont_e));
                this.fTv.setContainerBackgroundColorResId(ap.getColor(R.color.cp_bg_line_d));
                this.fTv.setLineColorResource(ap.getColor(R.color.cp_bg_line_c));
            }
            if (this.jrB != null) {
                this.jrB.onChangeSkinType();
            }
            if (this.jrC != null) {
                this.jrC.notifyDataSetChanged();
            }
            ap.setBackgroundColor(this.iSZ, R.color.cp_bg_line_e);
        }
    }

    public void hn(boolean z) {
        if (!cha()) {
            if (this.gcx == null) {
                this.gcx = new g(getContext());
                this.gcx.onChangeSkinType();
            }
            this.gcx.attachView(this, z);
        }
    }

    public void hideLoadingView() {
        if (this.gcx != null) {
            this.gcx.dettachView(this);
            this.gcx = null;
        }
    }

    public boolean cha() {
        if (this.gcx != null) {
            return this.gcx.isViewAttached();
        }
        return false;
    }

    public void ox(boolean z) {
        if (!chb()) {
            if (this.mRefreshView == null) {
                this.mRefreshView = new h(getContext(), new View.OnClickListener() { // from class: com.baidu.tieba.homepage.topic.topicdetail.view.TopicDetailView.2
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        if (j.isNetworkAvailableForImmediately() && TopicDetailView.this.jrz != null) {
                            TopicDetailView.this.jrz.loadData();
                        }
                    }
                });
            }
            this.mRefreshView.setLayoutMargin(this.mPageContext.getResources().getDimensionPixelSize(R.dimen.tbds506));
            this.mRefreshView.attachView(this, z);
            this.mRefreshView.showRefreshButton();
            this.iSZ.setVisibility(8);
            SvgManager.bmU().a(this.mBackImageView, R.drawable.icon_pure_topbar_return44_svg, R.color.cp_cont_f, SvgManager.SvgResourceStateType.NORMAL_PRESS);
        }
    }

    public void SK() {
        if (this.mRefreshView != null) {
            this.mRefreshView.dettachView(this);
            this.mRefreshView = null;
        }
        this.iSZ.setVisibility(0);
        SvgManager.bmU().a(this.mBackImageView, R.drawable.icon_pure_topbar_return44_svg, R.color.white_alpha100, SvgManager.SvgResourceStateType.NORMAL_PRESS);
    }

    public boolean chb() {
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
        this.iSZ.setOnSrollToBottomListener(null);
        if (this.fTu != null) {
            this.fTu.b(this.fRO);
        }
        if (this.jrH != null) {
            this.jrH.onDestory();
        }
        if (this.jrN != null) {
            com.baidu.adp.lib.f.e.mY().removeCallbacks(this.jrN);
        }
        hideLoadingView();
        SK();
    }

    public a getEditor() {
        return this.jrH;
    }

    public void setEditorTopViewAboveEditor() {
        if (this.jrI != null) {
            ViewGroup.LayoutParams layoutParams = this.jrI.getLayoutParams();
            if (layoutParams instanceof RelativeLayout.LayoutParams) {
                RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) layoutParams;
                if (this.jrH.bvf().isVisible()) {
                    layoutParams2.addRule(2, this.jrH.bvf().getId());
                } else {
                    layoutParams2.addRule(2, this.jrD.getId());
                }
                this.jrI.setLayoutParams(layoutParams2);
            }
        }
    }

    public void aD(bw bwVar) {
        int i;
        com.baidu.tieba.homepage.topic.topicdetail.b.c cVar;
        int i2 = 0;
        Iterator<q> it = this.mTopicDetailData.mDataList.iterator();
        while (true) {
            i = i2;
            if (!it.hasNext()) {
                cVar = null;
                break;
            }
            q next = it.next();
            if (next instanceof com.baidu.tieba.homepage.topic.topicdetail.b.c) {
                cVar = (com.baidu.tieba.homepage.topic.topicdetail.b.c) next;
                break;
            }
            i2 = i + 1;
        }
        if (cVar != null) {
            com.baidu.tieba.homepage.topic.topicdetail.b.c cVar2 = new com.baidu.tieba.homepage.topic.topicdetail.b.c();
            cVar2.jrb = cVar.jrb;
            cVar2.eji = bwVar;
            cVar2.source = 2;
            cVar2.jrc = this.jrL;
            cVar2.topicId = this.mTopicDetailData.topicId;
            cVar2.jrd = this.mTopicDetailData.cGp();
            this.mTopicDetailData.mDataList.add(i, cVar2);
            this.jrC.setData(this.mTopicDetailData.mDataList);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cGv() {
        if (this.mTopicDetailData != null && this.jrB != null) {
            if (this.jrO > this.jrP) {
                this.mNavigationBar.getBarBgView().setAlpha(1.0f);
                this.mNavigationBar.getBarBgView().setBackgroundDrawable(new BitmapDrawable(cGw()));
                return;
            }
            ap.setBackgroundColor(this.mNavigationBar.getBarBgView(), R.color.transparent);
            this.mNavigationBar.getBarBgView().setAlpha(0.0f);
        }
    }

    public Bitmap cGw() {
        Bitmap drawingCache;
        com.baidu.adp.widget.ImageView.a bdImage = this.jrB.getmBgImg().getBdImage();
        if (bdImage != null) {
            drawingCache = bdImage.getRawBitmap();
        } else {
            drawingCache = this.jrB.getmBgImg().getDrawingCache();
        }
        int width = this.mPageContext.getPageActivity().getWindowManager().getDefaultDisplay().getWidth();
        int height = this.mNavigationBar.getHeight();
        if (drawingCache != null && drawingCache.getWidth() >= width && drawingCache.getHeight() >= height) {
            return Bitmap.createBitmap(drawingCache, 0, 0, width, height);
        }
        return drawingCache;
    }
}
