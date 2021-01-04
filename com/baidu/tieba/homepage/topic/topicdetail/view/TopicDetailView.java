package com.baidu.tieba.homepage.topic.topicdetail.view;

import android.graphics.Bitmap;
import android.graphics.Typeface;
import android.graphics.drawable.BitmapDrawable;
import android.net.Uri;
import android.os.Bundle;
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
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.lib.util.j;
import com.baidu.adp.lib.util.l;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.adp.widget.ListView.BdTypeRecyclerView;
import com.baidu.adp.widget.ListView.n;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.live.tbadk.core.util.StringHelper;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.ShareDialogConfig;
import com.baidu.tbadk.core.data.AntiData;
import com.baidu.tbadk.core.data.bz;
import com.baidu.tbadk.core.util.SvgManager;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.util.at;
import com.baidu.tbadk.core.util.bg;
import com.baidu.tbadk.core.util.x;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tbadk.core.view.PbListView;
import com.baidu.tbadk.coreExtra.data.WriteData;
import com.baidu.tbadk.coreExtra.data.ah;
import com.baidu.tbadk.coreExtra.share.ShareItem;
import com.baidu.tbadk.l.g;
import com.baidu.tbadk.l.h;
import com.baidu.tieba.R;
import com.baidu.tieba.homepage.topic.topicdetail.TopicDetailActivity;
import com.baidu.tieba.homepage.topic.topicdetail.model.a;
import com.baidu.tieba.homepage.topic.topictab.view.TopicPkView;
import com.baidu.tieba.tbadkCore.writeModel.NewWriteModel;
import com.baidu.tieba.tbadkCore.writeModel.PostWriteCallBackData;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes2.dex */
public class TopicDetailView extends RelativeLayout implements View.OnClickListener {
    private BdListView.e WN;
    private com.baidu.tbadk.editortools.pb.b fGi;
    private NoNetworkView gCe;
    private PbListView gCf;
    private g gLj;
    private NoNetworkView.a gzW;
    private BdTypeRecyclerView jMh;
    private ImageView jQR;
    private View jhI;
    private TopicDetailHeadView klA;
    private com.baidu.tieba.homepage.topic.topicdetail.adapter.b klB;
    private View klC;
    private View klD;
    private TextView klE;
    private TextView klF;
    private a klG;
    private View klH;
    private com.baidu.tieba.write.c klI;
    private EditText klJ;
    private int klK;
    private com.baidu.tieba.homepage.topic.topicdetail.model.a klL;
    a.RunnableC0754a klM;
    private int klN;
    private int klO;
    private NewWriteModel.d klP;
    private com.baidu.tieba.homepage.topic.topicdetail.a klz;
    private ImageView mBackImageView;
    private boolean mHasMore;
    private NavigationBar mNavigationBar;
    private TbPageContext<?> mPageContext;
    private h mRefreshView;
    private final RecyclerView.OnScrollListener mScrollListener;
    private int mSkinType;
    private com.baidu.tieba.homepage.topic.topicdetail.a.a mTopicDetailData;

    public TopicDetailView(TbPageContext<?> tbPageContext, com.baidu.tieba.homepage.topic.topicdetail.a aVar, Bundle bundle) {
        super(tbPageContext.getPageActivity());
        this.mSkinType = 3;
        this.klD = null;
        this.klE = null;
        this.klF = null;
        this.mHasMore = true;
        this.klN = 0;
        this.klO = 44;
        this.gzW = new NoNetworkView.a() { // from class: com.baidu.tieba.homepage.topic.topicdetail.view.TopicDetailView.1
            @Override // com.baidu.tbadk.core.view.NoNetworkView.a
            public void onNetworkChange(boolean z) {
                if (z && TopicDetailView.this.mTopicDetailData == null && TopicDetailView.this.klz != null) {
                    TopicDetailView.this.klz.loadData();
                }
            }
        };
        this.fGi = new com.baidu.tbadk.editortools.pb.b() { // from class: com.baidu.tieba.homepage.topic.topicdetail.view.TopicDetailView.6
            @Override // com.baidu.tbadk.editortools.pb.b
            public boolean bFm() {
                if (TopicDetailView.this.klI.dXS()) {
                    TopicDetailView.this.mPageContext.showToast(TopicDetailView.this.klI.dXU());
                    TopicDetailView.this.sj(true);
                    return true;
                }
                return false;
            }
        };
        this.klP = new NewWriteModel.d() { // from class: com.baidu.tieba.homepage.topic.topicdetail.view.TopicDetailView.7
            @Override // com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.d
            public void callback(boolean z, PostWriteCallBackData postWriteCallBackData, ah ahVar, WriteData writeData, AntiData antiData) {
                if (z && TopicDetailView.this.klG != null && TopicDetailView.this.klG.bEI() != null) {
                    TopicDetailView.this.klG.bEI().hide();
                }
                if (z) {
                    TopicDetailView.this.klI.Vf(null);
                    TopicDetailView.this.klI.bm(null);
                    TopicDetailView.this.klI.zb(false);
                    if (postWriteCallBackData != null) {
                        long j = com.baidu.adp.lib.f.b.toLong(postWriteCallBackData.getPostId(), 0L);
                        long j2 = com.baidu.adp.lib.f.b.toLong(postWriteCallBackData.getThreadId(), 0L);
                        if (j != 0 && j2 != 0) {
                            TopicDetailView.this.klM = TopicDetailView.this.klL.C(j, j2);
                            com.baidu.adp.lib.f.e.mB().postDelayed(TopicDetailView.this.klM, 500L);
                        }
                    }
                } else if (postWriteCallBackData != null && postWriteCallBackData.isSensitiveError()) {
                    TopicDetailView.this.klI.bm(postWriteCallBackData.getSensitiveWords());
                    TopicDetailView.this.klI.Vf(postWriteCallBackData.getErrorString());
                    if (!x.isEmpty(TopicDetailView.this.klI.dXQ())) {
                        TopicDetailView.this.sj(true);
                    }
                }
            }
        };
        this.mScrollListener = new RecyclerView.OnScrollListener() { // from class: com.baidu.tieba.homepage.topic.topicdetail.view.TopicDetailView.8
            @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
            public void onScrollStateChanged(RecyclerView recyclerView, int i) {
                if (i != 0 && TopicDetailView.this.klG != null) {
                    TopicDetailView.this.klG.bFQ();
                    TopicDetailView.this.setEditorTopViewAboveEditor();
                }
                super.onScrollStateChanged(TopicDetailView.this.jMh, i);
            }

            @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
            public void onScrolled(RecyclerView recyclerView, int i, int i2) {
                super.onScrolled(recyclerView, i, i2);
                TopicDetailView.this.klN += i2;
                TopicDetailView.this.cUf();
            }
        };
        this.WN = new BdListView.e() { // from class: com.baidu.tieba.homepage.topic.topicdetail.view.TopicDetailView.9
            @Override // com.baidu.adp.widget.ListView.BdListView.e
            public void onScrollToBottom() {
                if (TopicDetailView.this.mHasMore) {
                    if (!l.isNetOk()) {
                        TopicDetailView.this.bVF();
                        return;
                    }
                    int size = TopicDetailView.this.mTopicDetailData.mDataList.size();
                    if (TopicDetailView.this.mTopicDetailData.mDataList.get(size - 1) instanceof com.baidu.tieba.homepage.topic.topicdetail.a.c) {
                        ((TopicDetailActivity) TopicDetailView.this.mPageContext.getPageActivity()).gC(((com.baidu.tieba.homepage.topic.topicdetail.a.c) TopicDetailView.this.mTopicDetailData.mDataList.get(size - 1)).kla);
                    }
                }
            }
        };
        this.mPageContext = tbPageContext;
        this.klz = aVar;
        init(bundle);
        onChangeSkinType();
    }

    private void init(Bundle bundle) {
        LayoutInflater.from(getContext()).inflate(R.layout.activity_topic_detail_layout, (ViewGroup) this, true);
        this.mNavigationBar = (NavigationBar) findViewById(R.id.activity_topic_detail_navigation);
        if (this.jhI == null) {
            this.jhI = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
            this.jhI.setOnClickListener(this);
            this.mBackImageView = (ImageView) this.jhI.findViewById(R.id.widget_navi_back_button);
        }
        this.jQR = (ImageView) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, R.layout.topic_detail_share_layout, this);
        SvgManager.bwq().a(this.jQR, R.drawable.icon_pure_topbar_share44_svg, R.color.white_alpha100, SvgManager.SvgResourceStateType.NORMAL_PRESS);
        ao.setViewTextColor(this.mNavigationBar.mCenterText, R.color.CAM_X0101);
        this.mNavigationBar.mCenterText.setTextSize(0, getResources().getDimensionPixelSize(R.dimen.tbds52));
        this.mNavigationBar.mCenterText.setTypeface(Typeface.defaultFromStyle(1));
        this.gCe = (NoNetworkView) findViewById(R.id.activity_topic_detail_no_network_view);
        this.gCe.a(this.gzW);
        this.klD = findViewById(R.id.pb_editor_tool_comment);
        this.klE = (TextView) findViewById(R.id.topic_editor_tool_comment_reply_text);
        this.klE.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.homepage.topic.topicdetail.view.TopicDetailView.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                TopicDetailView.this.cUe();
            }
        });
        this.klF = (TextView) findViewById(R.id.editor_tool_opinion_text_view);
        this.klC = findViewById(R.id.activity_topic_detail_editor);
        at(bundle);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
        layoutParams.addRule(12);
        addView(this.klG.bEI(), layoutParams);
        this.klI = new com.baidu.tieba.write.c();
        this.klH = findViewById(R.id.activity_topic_detail_editor_top);
        this.jMh = (BdTypeRecyclerView) findViewById(R.id.activity_topic_detail_list);
        this.jMh.setLayoutManager(new LinearLayoutManager(getContext()));
        this.jMh.setFadingEdgeLength(0);
        this.jMh.setOverScrollMode(2);
        this.jMh.setOnSrollToBottomListener(this.WN);
        this.jMh.addOnScrollListener(this.mScrollListener);
        ao.setBackgroundColor(this.jMh, R.color.CAM_X0201);
        this.klB = new com.baidu.tieba.homepage.topic.topicdetail.adapter.b(this.mPageContext, this.jMh);
        this.klA = new TopicDetailHeadView(getContext());
        this.klA.klx.setPkClickListener(new TopicPkView.b() { // from class: com.baidu.tieba.homepage.topic.topicdetail.view.TopicDetailView.4
            @Override // com.baidu.tieba.homepage.topic.topictab.view.TopicPkView.b
            public void Dt(int i) {
                TopicDetailView.this.Ds(i);
            }
        });
        if (this.gLj == null) {
            this.gCf = new PbListView(this.mPageContext.getPageActivity());
            this.gCf.getView();
        }
        this.gCf.setContainerBackgroundColorResId(R.color.CAM_X0205);
        this.gCf.setHeight(l.getDimens(this.mPageContext.getPageActivity(), R.dimen.tbds182));
        this.gCf.setTextSize(R.dimen.tbfontsize33);
        this.gCf.setNoMoreTextColorId(R.color.CAM_X0110);
        this.gCf.setTextColor(ao.getColor(R.color.CAM_X0110));
        this.gCf.setContainerBackgroundColorResId(ao.getColor(R.color.CAM_X0201));
        this.gCf.setLineColorResource(ao.getColor(R.color.CAM_X0204));
        this.gCf.setText(getResources().getString(R.string.list_has_no_more));
        this.gCf.getView().setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
        if (this.klL == null) {
            this.klL = new com.baidu.tieba.homepage.topic.topicdetail.model.a(this);
            this.klL.l(this.mPageContext.getUniqueId());
        }
    }

    private void at(Bundle bundle) {
        this.klG = (a) new b().fj(getContext());
        if (this.klG != null) {
            this.klG.a(this.mPageContext);
            this.klG.b(this.klP);
            this.klG.a(this.fGi);
            this.klG.bEI().kO(true);
            this.klG.bEI().setBarBackgroundColorId(R.color.CAM_X0207);
            this.klG.a((BaseActivity) getContext(), bundle);
            this.klG.bFQ();
            this.klG.bEI().setId(R.id.topic_editor);
            this.klJ = this.klG.cUd().getInputView();
            this.klJ.addTextChangedListener(new TextWatcher() { // from class: com.baidu.tieba.homepage.topic.topicdetail.view.TopicDetailView.5
                @Override // android.text.TextWatcher
                public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                }

                @Override // android.text.TextWatcher
                public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                }

                @Override // android.text.TextWatcher
                public void afterTextChanged(Editable editable) {
                    if (TopicDetailView.this.klI != null) {
                        if (!TopicDetailView.this.klI.dXT()) {
                            TopicDetailView.this.sj(false);
                        }
                        TopicDetailView.this.klI.zc(false);
                    }
                }
            });
        }
    }

    public void sj(boolean z) {
        if (this.klJ != null && this.klJ.getText() != null) {
            int selectionEnd = this.klJ.getSelectionEnd();
            SpannableStringBuilder d = this.klI.d(this.klJ.getText());
            if (d != null) {
                this.klI.zc(true);
                this.klJ.setText(d);
                if (z && this.klI.dXR() >= 0) {
                    this.klJ.requestFocus();
                    this.klJ.setSelection(this.klI.dXR());
                } else {
                    this.klJ.setSelection(selectionEnd);
                }
                this.klI.zb(this.klI.dXR() >= 0);
            }
        }
    }

    public void cUe() {
        if (bg.checkUpIsLogin(getContext())) {
            this.klG.bFT();
            setEditorTopViewAboveEditor();
        }
        if (this.mTopicDetailData != null) {
            TiebaStatic.log(new aq("c13359").dX("topic_id", String.valueOf(this.mTopicDetailData.topicId)));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Ds(int i) {
        this.klK = i;
        this.klF.setVisibility(0);
        if (i == 1) {
            this.klF.setText(R.string.topic_detail_pk_support);
            ao.setBackgroundResource(this.klF, R.drawable.topic_discuss_support_bg);
        } else if (i == 2) {
            this.klF.setText(R.string.topic_detail_pk_oppose);
            ao.setBackgroundResource(this.klF, R.drawable.topic_discuss_oppose_bg);
        } else {
            this.klF.setText(R.string.topic_detail_pk_chigua);
            ao.setBackgroundResource(this.klF, R.drawable.topic_discuss_opinion_bg);
        }
        if (this.mSkinType == 1 || this.mSkinType == 4) {
            this.klF.setTextColor(-2130706433);
        } else {
            ao.setViewTextColor(this.klF, R.color.CAM_X0101);
        }
    }

    public void setData(com.baidu.tieba.homepage.topic.topicdetail.a.a aVar) {
        int dimens;
        if (aVar != null) {
            this.mTopicDetailData = aVar;
            this.mHasMore = this.mTopicDetailData.hasMore;
            if (this.mHasMore && this.mTopicDetailData.mDataList.size() <= 4) {
                this.mHasMore = false;
                Zh();
            } else if (!this.mHasMore) {
                Zh();
            } else {
                Zg();
            }
            if (!StringUtils.isNull(aVar.eRS)) {
                this.mNavigationBar.setCenterTextTitle(String.format(getContext().getString(R.string.daily_topic_name), at.cutChineseAndEnglishWithSuffix(aVar.eRS, 14, StringHelper.STRING_MORE)));
            }
            this.klA.setData(aVar.kkS);
            this.jMh.addHeaderView(this.klA);
            this.klB.setData(aVar.mDataList);
            if (this.mTopicDetailData.kkS.kkX != null) {
                if (this.mTopicDetailData.kkS.kkX.kmr.kmx) {
                    Ds(1);
                } else if (this.mTopicDetailData.kkS.kkX.kms.kmx) {
                    Ds(2);
                } else {
                    Ds(0);
                }
                dimens = l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds140);
            } else {
                dimens = l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds50);
                this.klF.setVisibility(8);
            }
            this.klE.setPadding(dimens, 0, 0, 0);
            cUf();
        }
    }

    public void setNextData(int i, boolean z, List<n> list) {
        this.mHasMore = z;
        if (!this.mHasMore) {
            Zh();
        } else {
            Zg();
        }
        if (i == 0 && list != null && !x.isEmpty(list)) {
            for (n nVar : list) {
                if (nVar instanceof com.baidu.tieba.homepage.topic.topicdetail.a.c) {
                    ((com.baidu.tieba.homepage.topic.topicdetail.a.c) nVar).klc = this.mTopicDetailData.cTZ();
                }
            }
            this.mTopicDetailData.mDataList.addAll(list);
            this.jMh.setData(this.mTopicDetailData.mDataList);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bVF() {
        this.jMh.setNextPage(null);
    }

    public void Zg() {
        this.mHasMore = true;
        this.jMh.setNextPage(this.gCf);
        this.gCf.startLoadData();
    }

    public void Zh() {
        this.jMh.setNextPage(this.gCf);
        this.gCf.endLoadData();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.jhI) {
            this.mPageContext.getPageActivity().finish();
        } else if (view == this.jQR && this.mTopicDetailData != null && this.mTopicDetailData.topicId > 0) {
            bye();
            TiebaStatic.log(new aq("c13364").dX("topic_id", String.valueOf(this.mTopicDetailData.topicId)));
        }
    }

    private void bye() {
        if (this.mTopicDetailData != null && getContext() != null) {
            String valueOf = String.valueOf(this.mTopicDetailData.topicId);
            String str = this.mTopicDetailData.eRS;
            String str2 = this.mTopicDetailData.shareTitle;
            if (TextUtils.isEmpty(valueOf) || TextUtils.isEmpty(str)) {
                this.mPageContext.showToast(getContext().getString(R.string.no_hot_topic_data));
                return;
            }
            String str3 = "http://tieba.baidu.com/mo/q/newtopic/detail?topic_id=" + valueOf + "/";
            Uri parse = StringUtils.isNull(this.mTopicDetailData.kkR) ? null : Uri.parse(this.mTopicDetailData.kkR);
            final ShareItem shareItem = new ShareItem();
            shareItem.title = str;
            shareItem.content = str2;
            shareItem.linkUrl = str3;
            shareItem.fxe = true;
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
            cUf();
            ao.setViewTextColor(this.mNavigationBar.mCenterText, R.color.CAM_X0101);
            ao.setBackgroundResource(this.klD, R.color.CAM_X0207);
            ao.setViewTextColor(this.klE, R.color.CAM_X0109);
            this.klE.setBackgroundDrawable(ao.aO(l.getDimens(this.mPageContext.getPageActivity(), R.dimen.tbds47), ao.getColor(R.color.CAM_X0209)));
            Ds(this.klK);
            SvgManager.bwq().a(this.mBackImageView, R.drawable.ic_icon_pure_topbar_return40_svg, R.color.white_alpha100, SvgManager.SvgResourceStateType.NORMAL_PRESS);
            if (this.jQR != null) {
                SvgManager.bwq().a(this.jQR, R.drawable.icon_pure_topbar_share44_svg, R.color.white_alpha100, SvgManager.SvgResourceStateType.NORMAL_PRESS);
            }
            if (this.mPageContext != null && this.gCe != null) {
                this.gCe.onChangeSkinType(this.mPageContext, this.mSkinType);
            }
            if (this.gLj != null) {
                this.gLj.onChangeSkinType();
            }
            if (this.mRefreshView != null) {
                this.mRefreshView.onChangeSkinType();
            }
            if (this.klG != null && this.klG.bEI() != null) {
                this.klG.bEI().onChangeSkinType(this.mSkinType);
            }
            if (this.gCf != null) {
                this.gCf.setNoMoreTextColorId(R.color.CAM_X0110);
                this.gCf.setTextColor(ao.getColor(R.color.CAM_X0110));
                this.gCf.setContainerBackgroundColorResId(ao.getColor(R.color.CAM_X0201));
                this.gCf.setLineColorResource(ao.getColor(R.color.CAM_X0204));
            }
            if (this.klA != null) {
                this.klA.onChangeSkinType();
            }
            if (this.klB != null) {
                this.klB.notifyDataSetChanged();
            }
            ao.setBackgroundColor(this.jMh, R.color.CAM_X0205);
        }
    }

    public void it(boolean z) {
        if (!cts()) {
            if (this.gLj == null) {
                this.gLj = new g(getContext());
                this.gLj.onChangeSkinType();
            }
            this.gLj.attachView(this, z);
        }
    }

    public void hideLoadingView() {
        if (this.gLj != null) {
            this.gLj.dettachView(this);
            this.gLj = null;
        }
    }

    public boolean cts() {
        if (this.gLj != null) {
            return this.gLj.isViewAttached();
        }
        return false;
    }

    public void pU(boolean z) {
        if (!ctt()) {
            if (this.mRefreshView == null) {
                this.mRefreshView = new h(getContext(), new View.OnClickListener() { // from class: com.baidu.tieba.homepage.topic.topicdetail.view.TopicDetailView.2
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        if (j.isNetworkAvailableForImmediately() && TopicDetailView.this.klz != null) {
                            TopicDetailView.this.klz.loadData();
                        }
                    }
                });
            }
            this.mRefreshView.setLayoutMargin(this.mPageContext.getResources().getDimensionPixelSize(R.dimen.tbds506));
            this.mRefreshView.attachView(this, z);
            this.mRefreshView.showRefreshButton();
            this.jMh.setVisibility(8);
            SvgManager.bwq().a(this.mBackImageView, R.drawable.ic_icon_pure_topbar_return40_svg, R.color.CAM_X0106, SvgManager.SvgResourceStateType.NORMAL_PRESS);
        }
    }

    public void Zi() {
        if (this.mRefreshView != null) {
            this.mRefreshView.dettachView(this);
            this.mRefreshView = null;
        }
        this.jMh.setVisibility(0);
        SvgManager.bwq().a(this.mBackImageView, R.drawable.ic_icon_pure_topbar_return40_svg, R.color.white_alpha100, SvgManager.SvgResourceStateType.NORMAL_PRESS);
    }

    public boolean ctt() {
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
        this.jMh.setOnSrollToBottomListener(null);
        if (this.gCe != null) {
            this.gCe.b(this.gzW);
        }
        if (this.klG != null) {
            this.klG.onDestory();
        }
        if (this.klM != null) {
            com.baidu.adp.lib.f.e.mB().removeCallbacks(this.klM);
        }
        hideLoadingView();
        Zi();
    }

    public a getEditor() {
        return this.klG;
    }

    public void setEditorTopViewAboveEditor() {
        if (this.klH != null) {
            ViewGroup.LayoutParams layoutParams = this.klH.getLayoutParams();
            if (layoutParams instanceof RelativeLayout.LayoutParams) {
                RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) layoutParams;
                if (this.klG.bEI().isVisible()) {
                    layoutParams2.addRule(2, this.klG.bEI().getId());
                } else {
                    layoutParams2.addRule(2, this.klC.getId());
                }
                this.klH.setLayoutParams(layoutParams2);
            }
        }
    }

    public void aG(bz bzVar) {
        int i;
        com.baidu.tieba.homepage.topic.topicdetail.a.c cVar;
        int i2 = 0;
        Iterator<n> it = this.mTopicDetailData.mDataList.iterator();
        while (true) {
            i = i2;
            if (!it.hasNext()) {
                cVar = null;
                break;
            }
            n next = it.next();
            if (next instanceof com.baidu.tieba.homepage.topic.topicdetail.a.c) {
                cVar = (com.baidu.tieba.homepage.topic.topicdetail.a.c) next;
                break;
            }
            i2 = i + 1;
        }
        if (cVar != null) {
            com.baidu.tieba.homepage.topic.topicdetail.a.c cVar2 = new com.baidu.tieba.homepage.topic.topicdetail.a.c();
            cVar2.kla = cVar.kla;
            cVar2.eMv = bzVar;
            cVar2.source = 2;
            cVar2.klb = this.klK;
            cVar2.topicId = this.mTopicDetailData.topicId;
            cVar2.klc = this.mTopicDetailData.cTZ();
            this.mTopicDetailData.mDataList.add(i, cVar2);
            this.klB.setData(this.mTopicDetailData.mDataList);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cUf() {
        if (this.mTopicDetailData != null && this.klA != null) {
            if (this.klN > this.klO) {
                this.mNavigationBar.getBarBgView().setAlpha(1.0f);
                this.mNavigationBar.getBarBgView().setBackgroundDrawable(new BitmapDrawable(cUg()));
                return;
            }
            ao.setBackgroundColor(this.mNavigationBar.getBarBgView(), R.color.transparent);
            this.mNavigationBar.getBarBgView().setAlpha(0.0f);
        }
    }

    public Bitmap cUg() {
        Bitmap drawingCache;
        com.baidu.adp.widget.ImageView.a bdImage = this.klA.getmBgImg().getBdImage();
        if (bdImage != null) {
            drawingCache = bdImage.getRawBitmap();
        } else {
            drawingCache = this.klA.getmBgImg().getDrawingCache();
        }
        int width = this.mPageContext.getPageActivity().getWindowManager().getDefaultDisplay().getWidth();
        int height = this.mNavigationBar.getHeight();
        if (drawingCache != null && drawingCache.getWidth() >= width && drawingCache.getHeight() >= height) {
            return Bitmap.createBitmap(drawingCache, 0, 0, width, height);
        }
        return drawingCache;
    }
}
