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
import com.baidu.tbadk.core.data.cb;
import com.baidu.tbadk.core.util.SvgManager;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.ar;
import com.baidu.tbadk.core.util.au;
import com.baidu.tbadk.core.util.bh;
import com.baidu.tbadk.core.util.y;
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
    private BdListView.e WH;
    private com.baidu.tbadk.editortools.pb.b fDP;
    private NoNetworkView gAh;
    private PbListView gAi;
    private g gJn;
    private NoNetworkView.a gxZ;
    private BdTypeRecyclerView jNf;
    private ImageView jTp;
    private View jiI;
    private com.baidu.tieba.homepage.topic.topicdetail.a kpb;
    private TopicDetailHeadView kpc;
    private com.baidu.tieba.homepage.topic.topicdetail.adapter.b kpd;
    private View kpe;
    private View kpf;
    private TextView kpg;
    private TextView kph;
    private a kpi;
    private View kpj;
    private com.baidu.tieba.write.c kpk;
    private EditText kpl;
    private int kpm;
    private com.baidu.tieba.homepage.topic.topicdetail.model.a kpn;
    a.RunnableC0748a kpo;
    private int kpp;
    private int kpq;
    private NewWriteModel.d kpr;
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
        this.kpf = null;
        this.kpg = null;
        this.kph = null;
        this.mHasMore = true;
        this.kpp = 0;
        this.kpq = 44;
        this.gxZ = new NoNetworkView.a() { // from class: com.baidu.tieba.homepage.topic.topicdetail.view.TopicDetailView.1
            @Override // com.baidu.tbadk.core.view.NoNetworkView.a
            public void onNetworkChange(boolean z) {
                if (z && TopicDetailView.this.mTopicDetailData == null && TopicDetailView.this.kpb != null) {
                    TopicDetailView.this.kpb.loadData();
                }
            }
        };
        this.fDP = new com.baidu.tbadk.editortools.pb.b() { // from class: com.baidu.tieba.homepage.topic.topicdetail.view.TopicDetailView.6
            @Override // com.baidu.tbadk.editortools.pb.b
            public boolean bBL() {
                if (TopicDetailView.this.kpk.dWp()) {
                    TopicDetailView.this.mPageContext.showToast(TopicDetailView.this.kpk.dWr());
                    TopicDetailView.this.ss(true);
                    return true;
                }
                return false;
            }
        };
        this.kpr = new NewWriteModel.d() { // from class: com.baidu.tieba.homepage.topic.topicdetail.view.TopicDetailView.7
            @Override // com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.d
            public void callback(boolean z, PostWriteCallBackData postWriteCallBackData, ah ahVar, WriteData writeData, AntiData antiData) {
                if (z && TopicDetailView.this.kpi != null && TopicDetailView.this.kpi.bBh() != null) {
                    TopicDetailView.this.kpi.bBh().hide();
                }
                if (z) {
                    TopicDetailView.this.kpk.UV(null);
                    TopicDetailView.this.kpk.bg(null);
                    TopicDetailView.this.kpk.zt(false);
                    if (postWriteCallBackData != null) {
                        long j = com.baidu.adp.lib.f.b.toLong(postWriteCallBackData.getPostId(), 0L);
                        long j2 = com.baidu.adp.lib.f.b.toLong(postWriteCallBackData.getThreadId(), 0L);
                        if (j != 0 && j2 != 0) {
                            TopicDetailView.this.kpo = TopicDetailView.this.kpn.G(j, j2);
                            com.baidu.adp.lib.f.e.mA().postDelayed(TopicDetailView.this.kpo, 500L);
                        }
                    }
                } else if (postWriteCallBackData != null && postWriteCallBackData.isSensitiveError()) {
                    TopicDetailView.this.kpk.bg(postWriteCallBackData.getSensitiveWords());
                    TopicDetailView.this.kpk.UV(postWriteCallBackData.getErrorString());
                    if (!y.isEmpty(TopicDetailView.this.kpk.dWn())) {
                        TopicDetailView.this.ss(true);
                    }
                }
            }
        };
        this.mScrollListener = new RecyclerView.OnScrollListener() { // from class: com.baidu.tieba.homepage.topic.topicdetail.view.TopicDetailView.8
            @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
            public void onScrollStateChanged(RecyclerView recyclerView, int i) {
                if (i != 0 && TopicDetailView.this.kpi != null) {
                    TopicDetailView.this.kpi.bCq();
                    TopicDetailView.this.setEditorTopViewAboveEditor();
                }
                super.onScrollStateChanged(TopicDetailView.this.jNf, i);
            }

            @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
            public void onScrolled(RecyclerView recyclerView, int i, int i2) {
                super.onScrolled(recyclerView, i, i2);
                TopicDetailView.this.kpp += i2;
                TopicDetailView.this.cSn();
            }
        };
        this.WH = new BdListView.e() { // from class: com.baidu.tieba.homepage.topic.topicdetail.view.TopicDetailView.9
            @Override // com.baidu.adp.widget.ListView.BdListView.e
            public void onScrollToBottom() {
                if (TopicDetailView.this.mHasMore) {
                    if (!l.isNetOk()) {
                        TopicDetailView.this.bSr();
                        return;
                    }
                    int size = TopicDetailView.this.mTopicDetailData.mDataList.size();
                    if (TopicDetailView.this.mTopicDetailData.mDataList.get(size - 1) instanceof com.baidu.tieba.homepage.topic.topicdetail.a.c) {
                        ((TopicDetailActivity) TopicDetailView.this.mPageContext.getPageActivity()).gH(((com.baidu.tieba.homepage.topic.topicdetail.a.c) TopicDetailView.this.mTopicDetailData.mDataList.get(size - 1)).koC);
                    }
                }
            }
        };
        this.mPageContext = tbPageContext;
        this.kpb = aVar;
        init(bundle);
        onChangeSkinType();
    }

    private void init(Bundle bundle) {
        LayoutInflater.from(getContext()).inflate(R.layout.activity_topic_detail_layout, (ViewGroup) this, true);
        this.mNavigationBar = (NavigationBar) findViewById(R.id.activity_topic_detail_navigation);
        if (this.jiI == null) {
            this.jiI = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
            this.jiI.setOnClickListener(this);
            this.mBackImageView = (ImageView) this.jiI.findViewById(R.id.widget_navi_back_button);
        }
        this.jTp = (ImageView) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, R.layout.topic_detail_share_layout, this);
        SvgManager.bsR().a(this.jTp, R.drawable.icon_pure_topbar_share44_svg, R.color.white_alpha100, SvgManager.SvgResourceStateType.NORMAL_PRESS);
        ap.setViewTextColor(this.mNavigationBar.mCenterText, R.color.CAM_X0101);
        this.mNavigationBar.mCenterText.setTextSize(0, getResources().getDimensionPixelSize(R.dimen.tbds52));
        this.mNavigationBar.mCenterText.setTypeface(Typeface.defaultFromStyle(1));
        this.gAh = (NoNetworkView) findViewById(R.id.activity_topic_detail_no_network_view);
        this.gAh.a(this.gxZ);
        this.kpf = findViewById(R.id.pb_editor_tool_comment);
        this.kpg = (TextView) findViewById(R.id.topic_editor_tool_comment_reply_text);
        this.kpg.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.homepage.topic.topicdetail.view.TopicDetailView.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                TopicDetailView.this.cSm();
            }
        });
        this.kph = (TextView) findViewById(R.id.editor_tool_opinion_text_view);
        this.kpe = findViewById(R.id.activity_topic_detail_editor);
        at(bundle);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
        layoutParams.addRule(12);
        addView(this.kpi.bBh(), layoutParams);
        this.kpk = new com.baidu.tieba.write.c();
        this.kpj = findViewById(R.id.activity_topic_detail_editor_top);
        this.jNf = (BdTypeRecyclerView) findViewById(R.id.activity_topic_detail_list);
        this.jNf.setLayoutManager(new LinearLayoutManager(getContext()));
        this.jNf.setFadingEdgeLength(0);
        this.jNf.setOverScrollMode(2);
        this.jNf.setOnSrollToBottomListener(this.WH);
        this.jNf.addOnScrollListener(this.mScrollListener);
        ap.setBackgroundColor(this.jNf, R.color.CAM_X0201);
        this.kpd = new com.baidu.tieba.homepage.topic.topicdetail.adapter.b(this.mPageContext, this.jNf);
        this.kpc = new TopicDetailHeadView(getContext());
        this.kpc.koZ.setPkClickListener(new TopicPkView.b() { // from class: com.baidu.tieba.homepage.topic.topicdetail.view.TopicDetailView.4
            @Override // com.baidu.tieba.homepage.topic.topictab.view.TopicPkView.b
            public void Ce(int i) {
                TopicDetailView.this.Cd(i);
            }
        });
        if (this.gJn == null) {
            this.gAi = new PbListView(this.mPageContext.getPageActivity());
            this.gAi.getView();
        }
        this.gAi.setContainerBackgroundColorResId(R.color.CAM_X0205);
        this.gAi.setHeight(l.getDimens(this.mPageContext.getPageActivity(), R.dimen.tbds182));
        this.gAi.setTextSize(R.dimen.tbfontsize33);
        this.gAi.setNoMoreTextColorId(R.color.CAM_X0110);
        this.gAi.setTextColor(ap.getColor(R.color.CAM_X0110));
        this.gAi.setContainerBackgroundColorResId(ap.getColor(R.color.CAM_X0201));
        this.gAi.setLineColorResource(ap.getColor(R.color.CAM_X0204));
        this.gAi.setText(getResources().getString(R.string.list_has_no_more));
        this.gAi.getView().setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
        if (this.kpn == null) {
            this.kpn = new com.baidu.tieba.homepage.topic.topicdetail.model.a(this);
            this.kpn.l(this.mPageContext.getUniqueId());
        }
    }

    private void at(Bundle bundle) {
        this.kpi = (a) new b().fg(getContext());
        if (this.kpi != null) {
            this.kpi.a(this.mPageContext);
            this.kpi.b(this.kpr);
            this.kpi.a(this.fDP);
            this.kpi.bBh().kN(true);
            this.kpi.bBh().setBarBackgroundColorId(R.color.CAM_X0207);
            this.kpi.a((BaseActivity) getContext(), bundle);
            this.kpi.bCq();
            this.kpi.bBh().setId(R.id.topic_editor);
            this.kpl = this.kpi.cSl().getInputView();
            this.kpl.addTextChangedListener(new TextWatcher() { // from class: com.baidu.tieba.homepage.topic.topicdetail.view.TopicDetailView.5
                @Override // android.text.TextWatcher
                public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                }

                @Override // android.text.TextWatcher
                public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                }

                @Override // android.text.TextWatcher
                public void afterTextChanged(Editable editable) {
                    if (TopicDetailView.this.kpk != null) {
                        if (!TopicDetailView.this.kpk.dWq()) {
                            TopicDetailView.this.ss(false);
                        }
                        TopicDetailView.this.kpk.zu(false);
                    }
                }
            });
        }
    }

    public void ss(boolean z) {
        if (this.kpl != null && this.kpl.getText() != null) {
            int selectionEnd = this.kpl.getSelectionEnd();
            SpannableStringBuilder d = this.kpk.d(this.kpl.getText());
            if (d != null) {
                this.kpk.zu(true);
                this.kpl.setText(d);
                if (z && this.kpk.dWo() >= 0) {
                    this.kpl.requestFocus();
                    this.kpl.setSelection(this.kpk.dWo());
                } else {
                    this.kpl.setSelection(selectionEnd);
                }
                this.kpk.zt(this.kpk.dWo() >= 0);
            }
        }
    }

    public void cSm() {
        if (bh.checkUpIsLogin(getContext())) {
            this.kpi.bCt();
            setEditorTopViewAboveEditor();
        }
        if (this.mTopicDetailData != null) {
            TiebaStatic.log(new ar("c13359").dR("topic_id", String.valueOf(this.mTopicDetailData.topicId)));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Cd(int i) {
        this.kpm = i;
        this.kph.setVisibility(0);
        if (i == 1) {
            this.kph.setText(R.string.topic_detail_pk_support);
            ap.setBackgroundResource(this.kph, R.drawable.topic_discuss_support_bg);
        } else if (i == 2) {
            this.kph.setText(R.string.topic_detail_pk_oppose);
            ap.setBackgroundResource(this.kph, R.drawable.topic_discuss_oppose_bg);
        } else {
            this.kph.setText(R.string.topic_detail_pk_chigua);
            ap.setBackgroundResource(this.kph, R.drawable.topic_discuss_opinion_bg);
        }
        if (this.mSkinType == 1 || this.mSkinType == 4) {
            this.kph.setTextColor(-2130706433);
        } else {
            ap.setViewTextColor(this.kph, R.color.CAM_X0101);
        }
    }

    public void setData(com.baidu.tieba.homepage.topic.topicdetail.a.a aVar) {
        int dimens;
        if (aVar != null) {
            this.mTopicDetailData = aVar;
            this.mHasMore = this.mTopicDetailData.hasMore;
            if (this.mHasMore && this.mTopicDetailData.mDataList.size() <= 4) {
                this.mHasMore = false;
                WY();
            } else if (!this.mHasMore) {
                WY();
            } else {
                WX();
            }
            if (!StringUtils.isNull(aVar.ePt)) {
                this.mNavigationBar.setCenterTextTitle(String.format(getContext().getString(R.string.daily_topic_name), au.cutChineseAndEnglishWithSuffix(aVar.ePt, 14, StringHelper.STRING_MORE)));
            }
            this.kpc.setData(aVar.kou);
            this.jNf.addHeaderView(this.kpc);
            this.kpd.setData(aVar.mDataList);
            if (this.mTopicDetailData.kou.koz != null) {
                if (this.mTopicDetailData.kou.koz.kpT.kpZ) {
                    Cd(1);
                } else if (this.mTopicDetailData.kou.koz.kpU.kpZ) {
                    Cd(2);
                } else {
                    Cd(0);
                }
                dimens = l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds140);
            } else {
                dimens = l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds50);
                this.kph.setVisibility(8);
            }
            this.kpg.setPadding(dimens, 0, 0, 0);
            cSn();
        }
    }

    public void setNextData(int i, boolean z, List<n> list) {
        this.mHasMore = z;
        if (!this.mHasMore) {
            WY();
        } else {
            WX();
        }
        if (i == 0 && list != null && !y.isEmpty(list)) {
            for (n nVar : list) {
                if (nVar instanceof com.baidu.tieba.homepage.topic.topicdetail.a.c) {
                    ((com.baidu.tieba.homepage.topic.topicdetail.a.c) nVar).koE = this.mTopicDetailData.cSh();
                }
            }
            this.mTopicDetailData.mDataList.addAll(list);
            this.jNf.setData(this.mTopicDetailData.mDataList);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bSr() {
        this.jNf.setNextPage(null);
    }

    public void WX() {
        this.mHasMore = true;
        this.jNf.setNextPage(this.gAi);
        this.gAi.startLoadData();
    }

    public void WY() {
        this.jNf.setNextPage(this.gAi);
        this.gAi.endLoadData();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.jiI) {
            this.mPageContext.getPageActivity().finish();
        } else if (view == this.jTp && this.mTopicDetailData != null && this.mTopicDetailData.topicId > 0) {
            buF();
            TiebaStatic.log(new ar("c13364").dR("topic_id", String.valueOf(this.mTopicDetailData.topicId)));
        }
    }

    private void buF() {
        if (this.mTopicDetailData != null && getContext() != null) {
            String valueOf = String.valueOf(this.mTopicDetailData.topicId);
            String str = this.mTopicDetailData.ePt;
            String str2 = this.mTopicDetailData.shareTitle;
            if (TextUtils.isEmpty(valueOf) || TextUtils.isEmpty(str)) {
                this.mPageContext.showToast(getContext().getString(R.string.no_hot_topic_data));
                return;
            }
            String str3 = "http://tieba.baidu.com/mo/q/newtopic/detail?topic_id=" + valueOf + "/";
            Uri parse = StringUtils.isNull(this.mTopicDetailData.kot) ? null : Uri.parse(this.mTopicDetailData.kot);
            final ShareItem shareItem = new ShareItem();
            shareItem.title = str;
            shareItem.content = str2;
            shareItem.linkUrl = str3;
            shareItem.fuN = true;
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
            cSn();
            ap.setViewTextColor(this.mNavigationBar.mCenterText, R.color.CAM_X0101);
            ap.setBackgroundResource(this.kpf, R.color.CAM_X0207);
            ap.setViewTextColor(this.kpg, R.color.CAM_X0109);
            this.kpg.setBackgroundDrawable(ap.aL(l.getDimens(this.mPageContext.getPageActivity(), R.dimen.tbds47), ap.getColor(R.color.CAM_X0209)));
            Cd(this.kpm);
            SvgManager.bsR().a(this.mBackImageView, R.drawable.ic_icon_pure_topbar_return40_svg, R.color.white_alpha100, SvgManager.SvgResourceStateType.NORMAL_PRESS);
            if (this.jTp != null) {
                SvgManager.bsR().a(this.jTp, R.drawable.icon_pure_topbar_share44_svg, R.color.white_alpha100, SvgManager.SvgResourceStateType.NORMAL_PRESS);
            }
            if (this.mPageContext != null && this.gAh != null) {
                this.gAh.onChangeSkinType(this.mPageContext, this.mSkinType);
            }
            if (this.gJn != null) {
                this.gJn.onChangeSkinType();
            }
            if (this.mRefreshView != null) {
                this.mRefreshView.onChangeSkinType();
            }
            if (this.kpi != null && this.kpi.bBh() != null) {
                this.kpi.bBh().onChangeSkinType(this.mSkinType);
            }
            if (this.gAi != null) {
                this.gAi.setNoMoreTextColorId(R.color.CAM_X0110);
                this.gAi.setTextColor(ap.getColor(R.color.CAM_X0110));
                this.gAi.setContainerBackgroundColorResId(ap.getColor(R.color.CAM_X0201));
                this.gAi.setLineColorResource(ap.getColor(R.color.CAM_X0204));
            }
            if (this.kpc != null) {
                this.kpc.onChangeSkinType();
            }
            if (this.kpd != null) {
                this.kpd.notifyDataSetChanged();
            }
            ap.setBackgroundColor(this.jNf, R.color.CAM_X0205);
        }
    }

    public void ir(boolean z) {
        if (!cqL()) {
            if (this.gJn == null) {
                this.gJn = new g(getContext());
                this.gJn.onChangeSkinType();
            }
            this.gJn.attachView(this, z);
        }
    }

    public void hideLoadingView() {
        if (this.gJn != null) {
            this.gJn.dettachView(this);
            this.gJn = null;
        }
    }

    public boolean cqL() {
        if (this.gJn != null) {
            return this.gJn.isViewAttached();
        }
        return false;
    }

    public void qa(boolean z) {
        if (!cqM()) {
            if (this.mRefreshView == null) {
                this.mRefreshView = new h(getContext(), new View.OnClickListener() { // from class: com.baidu.tieba.homepage.topic.topicdetail.view.TopicDetailView.2
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        if (j.isNetworkAvailableForImmediately() && TopicDetailView.this.kpb != null) {
                            TopicDetailView.this.kpb.loadData();
                        }
                    }
                });
            }
            this.mRefreshView.setLayoutMargin(this.mPageContext.getResources().getDimensionPixelSize(R.dimen.tbds506));
            this.mRefreshView.attachView(this, z);
            this.mRefreshView.showRefreshButton();
            this.jNf.setVisibility(8);
            SvgManager.bsR().a(this.mBackImageView, R.drawable.ic_icon_pure_topbar_return40_svg, R.color.CAM_X0106, SvgManager.SvgResourceStateType.NORMAL_PRESS);
        }
    }

    public void WZ() {
        if (this.mRefreshView != null) {
            this.mRefreshView.dettachView(this);
            this.mRefreshView = null;
        }
        this.jNf.setVisibility(0);
        SvgManager.bsR().a(this.mBackImageView, R.drawable.ic_icon_pure_topbar_return40_svg, R.color.white_alpha100, SvgManager.SvgResourceStateType.NORMAL_PRESS);
    }

    public boolean cqM() {
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
        this.jNf.setOnSrollToBottomListener(null);
        if (this.gAh != null) {
            this.gAh.b(this.gxZ);
        }
        if (this.kpi != null) {
            this.kpi.onDestory();
        }
        if (this.kpo != null) {
            com.baidu.adp.lib.f.e.mA().removeCallbacks(this.kpo);
        }
        hideLoadingView();
        WZ();
    }

    public a getEditor() {
        return this.kpi;
    }

    public void setEditorTopViewAboveEditor() {
        if (this.kpj != null) {
            ViewGroup.LayoutParams layoutParams = this.kpj.getLayoutParams();
            if (layoutParams instanceof RelativeLayout.LayoutParams) {
                RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) layoutParams;
                if (this.kpi.bBh().isVisible()) {
                    layoutParams2.addRule(2, this.kpi.bBh().getId());
                } else {
                    layoutParams2.addRule(2, this.kpe.getId());
                }
                this.kpj.setLayoutParams(layoutParams2);
            }
        }
    }

    public void aH(cb cbVar) {
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
            cVar2.koC = cVar.koC;
            cVar2.eJQ = cbVar;
            cVar2.source = 2;
            cVar2.koD = this.kpm;
            cVar2.topicId = this.mTopicDetailData.topicId;
            cVar2.koE = this.mTopicDetailData.cSh();
            this.mTopicDetailData.mDataList.add(i, cVar2);
            this.kpd.setData(this.mTopicDetailData.mDataList);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cSn() {
        if (this.mTopicDetailData != null && this.kpc != null) {
            if (this.kpp > this.kpq) {
                this.mNavigationBar.getBarBgView().setAlpha(1.0f);
                this.mNavigationBar.getBarBgView().setBackgroundDrawable(new BitmapDrawable(cSo()));
                return;
            }
            ap.setBackgroundColor(this.mNavigationBar.getBarBgView(), R.color.transparent);
            this.mNavigationBar.getBarBgView().setAlpha(0.0f);
        }
    }

    public Bitmap cSo() {
        Bitmap drawingCache;
        com.baidu.adp.widget.ImageView.a bdImage = this.kpc.getmBgImg().getBdImage();
        if (bdImage != null) {
            drawingCache = bdImage.getRawBitmap();
        } else {
            drawingCache = this.kpc.getmBgImg().getDrawingCache();
        }
        int width = this.mPageContext.getPageActivity().getWindowManager().getDefaultDisplay().getWidth();
        int height = this.mNavigationBar.getHeight();
        if (drawingCache != null && drawingCache.getWidth() >= width && drawingCache.getHeight() >= height) {
            return Bitmap.createBitmap(drawingCache, 0, 0, width, height);
        }
        return drawingCache;
    }
}
