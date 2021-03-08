package com.baidu.tieba.homepage.topic.topicdetail.view;

import android.graphics.Rect;
import android.text.SpannableString;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.lib.util.l;
import com.baidu.live.tbadk.core.data.RequestResponseCode;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.live.tbadk.core.util.StringHelper;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.ImageViewerConfig;
import com.baidu.tbadk.core.atomData.PbActivityConfig;
import com.baidu.tbadk.core.atomData.PersonPolymericActivityConfig;
import com.baidu.tbadk.core.data.MediaData;
import com.baidu.tbadk.core.data.MetaData;
import com.baidu.tbadk.core.data.cb;
import com.baidu.tbadk.core.k;
import com.baidu.tbadk.core.message.HistoryMessage;
import com.baidu.tbadk.core.util.SvgManager;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.ar;
import com.baidu.tbadk.core.util.au;
import com.baidu.tbadk.core.util.y;
import com.baidu.tbadk.core.view.AgreeView;
import com.baidu.tbadk.core.view.ClickableHeaderImageView;
import com.baidu.tbadk.coreExtra.view.ImageUrlData;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tbadk.widget.layout.ConstrainImageGroup;
import com.baidu.tbadk.widget.layout.ConstrainImageLayout;
import com.baidu.tbadk.widget.richText.TbRichTextView;
import com.baidu.tieba.R;
import com.baidu.tieba.card.m;
import com.baidu.tieba.tbadkCore.data.AgreeData;
import com.baidu.tieba.tbadkCore.data.PostData;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import tbclient.PbContent;
/* loaded from: classes2.dex */
public class d extends com.baidu.tieba.card.b<com.baidu.tieba.homepage.topic.topicdetail.a.c> {
    private boolean amh;
    private TextView eKp;
    private TbPageContext eWx;
    private ConstrainImageGroup iyU;
    private com.baidu.tieba.homepage.topic.topicdetail.a.c krJ;
    private ClickableHeaderImageView krK;
    private ImageView krL;
    private TextView krM;
    private AgreeView krN;
    private TextView krO;
    private ImageView krP;
    private TbRichTextView krQ;
    private RelativeLayout krR;
    private View krS;
    private TbImageView krT;
    private TextView krU;
    private View mBottomLine;
    private int mSkinType;

    public d(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.amh = true;
        this.mSkinType = 3;
        this.eWx = tbPageContext;
        initUI();
    }

    private void initUI() {
        View view = getView();
        this.krK = (ClickableHeaderImageView) view.findViewById(R.id.card_topic_detail_discuss_thread_user_header);
        this.krL = (ImageView) view.findViewById(R.id.card_topic_detail_thread_opinion_img);
        this.eKp = (TextView) view.findViewById(R.id.card_topic_detail_discuss_thread_user_name);
        this.krM = (TextView) view.findViewById(R.id.card_topic_detail_discuss_thread_forum_name);
        this.krQ = (TbRichTextView) view.findViewById(R.id.card_topic_detail_discuss_title);
        this.krQ.setClickable(true);
        this.krQ.setTextEllipsize(TextUtils.TruncateAt.END);
        this.krQ.setMaxLines(2);
        com.baidu.tbadk.widget.richText.a aVar = new com.baidu.tbadk.widget.richText.a();
        aVar.setTextSize(l.getDimens(getContext(), R.dimen.tbds44));
        aVar.setLineSpacing(l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds7), 1.0f);
        this.krQ.setLayoutStrategy(aVar);
        this.krR = (RelativeLayout) view.findViewById(R.id.topic_detail_img_container);
        this.iyU = (ConstrainImageGroup) view.findViewById(R.id.card_topic_detail_discuss_thread_img_layout);
        this.iyU.setImageMargin(TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds10));
        com.baidu.tbadk.widget.layout.a aVar2 = new com.baidu.tbadk.widget.layout.a(3);
        aVar2.r(1.0d);
        this.iyU.setImageProcessor(aVar2);
        this.krN = (AgreeView) view.findViewById(R.id.card_topic_detail_discuss_argee_view);
        this.krN.btM();
        this.krO = (TextView) view.findViewById(R.id.topic_comment_number);
        this.krP = (ImageView) view.findViewById(R.id.topic_comment_pic);
        this.krS = view.findViewById(R.id.card_topic_detail_discuss_original_thread_layout);
        this.krT = (TbImageView) view.findViewById(R.id.card_topic_discuss_original_thread_pic);
        this.krT.setRadius(l.getDimens(getContext(), R.dimen.tbds6));
        this.krT.setConrers(5);
        this.krT.setDrawCorner(true);
        this.krU = (TextView) view.findViewById(R.id.card_topic_discuss_original_thread_title);
        this.mBottomLine = view.findViewById(R.id.card_topic_detail_discuss_line_layout);
        this.eKp.setOnClickListener(this);
        this.krO.setOnClickListener(this);
        this.krP.setOnClickListener(this);
        this.krQ.setOnClickListener(this);
        this.krS.setOnClickListener(this);
        this.krU.setOnClickListener(this);
    }

    public void setConstrainLayoutPool(com.baidu.adp.lib.d.b<ConstrainImageLayout> bVar) {
        if (this.iyU != null) {
            this.iyU.setConstrainLayoutPool(bVar);
        }
    }

    public void setConstrainImagePool(com.baidu.adp.lib.d.b<TbImageView> bVar) {
        if (this.iyU != null) {
            this.iyU.setImageViewPool(bVar);
        }
    }

    @Override // com.baidu.tieba.card.b
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i && this.krJ != null) {
            this.mSkinType = i;
            this.krK.setIsNight(this.mSkinType == 1);
            if (this.krJ.kqU) {
                if (this.krJ.kqT == 1) {
                    ap.setImageResource(this.krL, R.drawable.label_topic_agree_red);
                    this.krK.setBorderColor(this.eWx.getPageActivity().getResources().getColor(R.color.CAM_X0301));
                } else if (this.krJ.kqT == 2) {
                    ap.setImageResource(this.krL, R.drawable.label_topic_disagree_blue);
                    this.krK.setBorderColor(this.eWx.getPageActivity().getResources().getColor(R.color.CAM_X0302));
                } else {
                    ap.setImageResource(this.krL, R.drawable.label_topic_eat_black);
                    this.krK.setBorderColor(this.eWx.getPageActivity().getResources().getColor(R.color.CAM_X0106));
                }
            }
            ap.setViewTextColor(this.eKp, R.color.CAM_X0105);
            ap.setViewTextColor(this.krM, R.color.CAM_X0109);
            ap.setViewTextColor(this.krO, R.color.CAM_X0107);
            if (this.krP != null) {
                SvgManager.bsU().a(this.krP, R.drawable.icon_pure_topic_reply16_svg, R.color.CAM_X0107, (SvgManager.SvgResourceStateType) null);
            }
            this.krN.onChangeSkinType(i);
            this.krQ.setTextColor(ap.getColor(R.color.CAM_X0105));
            ap.d(this.krS, l.getDimens(this.eWx.getPageActivity(), R.dimen.tbds6), R.color.CAM_X0209, R.color.cp_bg_line_j_alpha50);
            ap.setViewTextColor(this.krU, R.color.CAM_X0109);
            this.iyU.onChangeSkinType();
            ap.setBackgroundColor(this.mBottomLine, R.color.CAM_X0205);
        }
    }

    @Override // com.baidu.tieba.card.b
    public int getLayout() {
        return R.layout.topic_discuss_view;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.b
    public void a(com.baidu.tieba.homepage.topic.topicdetail.a.c cVar) {
        String name_show;
        String formatTime;
        int bnJ;
        AgreeData bpL;
        if (cVar != null && cVar.eLr != null) {
            this.krJ = cVar;
            onChangeSkinType(this.eWx, TbadkCoreApplication.getInst().getSkinType());
            cb cbVar = this.krJ.eLr;
            PostData bpx = cbVar.bpx();
            if (bpx != null) {
                this.krK.setPlaceHolder(1);
                if (this.krJ.source == 1) {
                    this.krK.setData(cbVar, false, true);
                } else {
                    this.krK.setData(cbVar, false, false);
                }
                this.krK.setIsRound(true);
                this.krK.setBorderWidth(2);
                this.krK.setDrawBorder(true);
                this.krK.setPageId(this.eWx.getUniqueId());
                if (this.krJ.kqU) {
                    this.krL.setVisibility(0);
                    if (this.krJ.kqT == 1) {
                        this.krL.setImageResource(R.drawable.label_topic_agree_red);
                        this.krK.setBorderColor(this.eWx.getPageActivity().getResources().getColor(R.color.CAM_X0301));
                    } else if (this.krJ.kqT == 2) {
                        this.krL.setImageResource(R.drawable.label_topic_disagree_blue);
                        this.krK.setBorderColor(this.eWx.getPageActivity().getResources().getColor(R.color.CAM_X0302));
                    } else {
                        this.krL.setImageResource(R.drawable.label_topic_eat_black);
                        this.krK.setBorderColor(this.eWx.getPageActivity().getResources().getColor(R.color.CAM_X0106));
                    }
                } else {
                    this.krL.setVisibility(8);
                }
                if (this.krJ.source == 1) {
                    name_show = bpx.bnS().getName_show();
                    formatTime = au.getFormatTime(bpx.getTime());
                    bnJ = bpx.dNS();
                } else {
                    name_show = cbVar.bnS().getName_show();
                    formatTime = au.getFormatTime(cbVar.getCreateTime());
                    bnJ = cbVar.bnJ();
                }
                if (!StringUtils.isNull(name_show)) {
                    this.eKp.setText(au.cutChineseAndEnglishWithSuffix(name_show, 14, StringHelper.STRING_MORE));
                }
                if (StringUtils.isNull(cbVar.bnW())) {
                    this.krM.setText(formatTime);
                } else {
                    this.krM.setText(String.format(getContext().getString(R.string.daily_topic_discuss_forum_name), au.cutChineseAndEnglishWithSuffix(cbVar.bnW(), 10, StringHelper.STRING_MORE), formatTime));
                }
                SvgManager.bsU().a(this.krP, R.drawable.icon_pure_topic_reply16_svg, R.color.CAM_X0107, SvgManager.SvgResourceStateType.NORMAL_PRESS);
                String numFormatOverWan = au.numFormatOverWan(bnJ);
                if (bnJ > 0) {
                    this.krO.setVisibility(0);
                    this.krO.setText(numFormatOverWan);
                } else {
                    this.krO.setText(this.eWx.getString(R.string.action_comment_default));
                    this.krO.setVisibility(0);
                }
                if (this.krJ.source == 1) {
                    bpL = bpx.bpL();
                    bpL.objType = 1;
                } else {
                    bpL = cbVar.bpL();
                    bpL.objType = 3;
                }
                bpL.threadId = cbVar.getTid();
                this.krN.setData(bpL);
                this.krN.setTopicId(String.valueOf(this.krJ.topicId));
                a(bpx, cbVar);
                a(cVar, cbVar);
                setPageUniqueId(getTag());
            }
        }
    }

    private void a(PostData postData, cb cbVar) {
        if (this.krJ.source == 1) {
            this.krQ.setVisibility(0);
            this.krQ.setText(postData.dNQ());
            return;
        }
        List<PbContent> bnI = cbVar.bnI();
        if (y.getCount(bnI) > 0) {
            this.krQ.setVisibility(0);
            this.krQ.setText(TbRichTextView.a(getContext(), bnI, false));
            return;
        }
        SpannableString boO = cbVar.boO();
        if (boO != null && !StringUtils.isNull(boO.toString())) {
            this.krQ.setVisibility(0);
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("type", "0");
                jSONObject.put("text", boO);
            } catch (JSONException e) {
                e.printStackTrace();
            }
            JSONArray jSONArray = new JSONArray();
            jSONArray.put(jSONObject);
            this.krQ.setText(TbRichTextView.a(getContext(), jSONArray, false));
            return;
        }
        this.krQ.setVisibility(8);
    }

    private void a(com.baidu.tieba.homepage.topic.topicdetail.a.c cVar, cb cbVar) {
        if (this.krJ.source == 1) {
            this.krS.setVisibility(0);
            this.krR.setVisibility(8);
            String title = cbVar.getTitle();
            if (StringUtils.isNull(title)) {
                this.krS.setVisibility(8);
                return;
            }
            this.krS.setVisibility(0);
            this.krU.setText(title);
            String str = null;
            if (y.getCount(cbVar.bob()) != 0 && !y.isEmpty(cVar.eLr.bob())) {
                Iterator<MediaData> it = cVar.eLr.bob().iterator();
                while (it.hasNext()) {
                    MediaData next = it.next();
                    if (next != null && next.getType() == 3) {
                        str = next.getPicUrl();
                        if (StringUtils.isNull(str)) {
                            str = next.getSmallUrl();
                        }
                        if (StringUtils.isNull(str)) {
                            str = next.getThumbnails_url();
                        }
                        if (StringUtils.isNull(str)) {
                            str = next.getSrc_pic();
                        }
                        if (!StringUtils.isNull(str)) {
                            break;
                        }
                    }
                }
            }
            if (StringUtils.isNull(str)) {
                ap.setImageResource(this.krT, R.drawable.pic_frs_topic_shareinone);
                return;
            }
            this.krT.setPlaceHolder(1);
            this.krT.startLoad(str, 10, false);
            return;
        }
        this.krS.setVisibility(8);
        this.krR.setVisibility(0);
        b(cVar);
    }

    private void b(com.baidu.tieba.homepage.topic.topicdetail.a.c cVar) {
        final cb cbVar = cVar.eLr;
        ArrayList<MediaData> bob = cbVar.bob();
        if (k.bkV().isShowImages() && y.getCount(bob) != 0) {
            final LinkedList linkedList = new LinkedList();
            for (int i = 0; i < bob.size(); i++) {
                MediaData mediaData = (MediaData) y.getItem(bob, i);
                if (mediaData != null && mediaData.getType() == 3) {
                    linkedList.add(mediaData);
                }
            }
            if (y.getCount(linkedList) > 0) {
                this.krR.setVisibility(0);
                this.iyU.setFromCDN(this.amh);
                this.iyU.setImageClickListener(new com.baidu.tbadk.widget.layout.d() { // from class: com.baidu.tieba.homepage.topic.topicdetail.view.d.1
                    @Override // com.baidu.tbadk.widget.layout.d
                    public void c(View view, int i2, boolean z) {
                        if (!z) {
                            d.this.a(view, linkedList, i2, cbVar);
                        } else {
                            d.this.bzn();
                        }
                    }
                });
                this.iyU.setImageMediaList(linkedList);
                return;
            }
            this.krR.setVisibility(8);
            return;
        }
        this.krR.setVisibility(8);
    }

    private void setPageUniqueId(BdUniqueId bdUniqueId) {
        setTag(bdUniqueId);
        if (this.iyU != null) {
            this.iyU.setPageUniqueId(bdUniqueId);
        }
    }

    public void bzn() {
        if (this.krJ != null && this.krJ.eLr != null) {
            PbActivityConfig addLocateParam = new PbActivityConfig(this.eWx.getPageActivity()).createFromThreadCfg(this.krJ.eLr, null, "none", RequestResponseCode.REQUEST_FRS_TO_PB, true, false, false).addLocateParam(null);
            addLocateParam.setForumId(String.valueOf(this.krJ.eLr.getFid()));
            addLocateParam.setFrom(PbActivityConfig.KEY_FROM_PERSONALIZE);
            addLocateParam.setForumName(this.krJ.eLr.bnW());
            addLocateParam.setStartFrom(this.currentPageType);
            addLocateParam.setJumpGodReply(false);
            addLocateParam.setJumpToCommentArea(true);
            m.IW(this.krJ.eLr.getTid());
            this.mTbPageContext.sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, addLocateParam));
        }
    }

    private void cSD() {
        PbActivityConfig createNormalCfg = new PbActivityConfig(this.eWx.getPageActivity()).createNormalCfg(String.valueOf(this.krJ.eLr.getTid()), String.format("%1$s", this.krJ.eLr.bpx().getId()) + "", 1, "mention");
        createNormalCfg.setStartFrom(12);
        createNormalCfg.setJumpToCommentArea(true);
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, createNormalCfg));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(View view, List<MediaData> list, int i, cb cbVar) {
        if (!TbadkCoreApplication.getInst().appResponseToCmd(CmdConfigCustom.IMAGE_VIEWER_CUSTOM_CMD)) {
            l.showToast(this.mTbPageContext.getPageActivity(), R.string.plugin_image_viewer_install_error_tips);
            return;
        }
        ArrayList<String> arrayList = new ArrayList<>();
        ConcurrentHashMap<String, ImageUrlData> concurrentHashMap = new ConcurrentHashMap<>();
        for (MediaData mediaData : list) {
            if (!TextUtils.isEmpty(mediaData.getSrc_pic())) {
                arrayList.add(mediaData.getSrc_pic());
                if (!TextUtils.isEmpty(mediaData.getPicUrl())) {
                    ImageUrlData imageUrlData = new ImageUrlData();
                    imageUrlData.urlType = this.amh ? 13 : 14;
                    imageUrlData.imageUrl = mediaData.getPicUrl();
                    imageUrlData.originalUrl = mediaData.getOriginalUrl();
                    imageUrlData.originalSize = mediaData.getOriginalSize();
                    imageUrlData.isLongPic = mediaData.isLongPic();
                    imageUrlData.mIsShowOrigonButton = mediaData.isShowOriginBtn();
                    imageUrlData.threadId = com.baidu.adp.lib.f.b.toLong(cbVar.getTid(), -1L);
                    imageUrlData.postId = mediaData.getPostId();
                    concurrentHashMap.put(mediaData.getSrc_pic(), imageUrlData);
                }
            }
        }
        if (arrayList.size() <= 0) {
            for (MediaData mediaData2 : list) {
                if (!TextUtils.isEmpty(mediaData2.getPicUrl())) {
                    arrayList.add(mediaData2.getPicUrl());
                }
            }
        }
        Rect rect = new Rect();
        view.getGlobalVisibleRect(rect);
        ImageViewerConfig.a aVar = new ImageViewerConfig.a();
        aVar.s(arrayList).mR(i).zQ(cbVar.bnW()).zR(String.valueOf(cbVar.getFid())).zS(cbVar.getTid()).jg(this.amh).zT(arrayList.size() > 0 ? arrayList.get(0) : "").jh(true).d(concurrentHashMap).ji(true).s(cbVar).a(rect, UtilHelper.fixedDrawableRect(rect, view));
        ImageViewerConfig eO = aVar.eO(this.mTbPageContext.getPageActivity());
        if (this.currentPageType == 2) {
            eO.getIntent().putExtra("from", "index");
        } else {
            eO.getIntent().putExtra("from", "other");
        }
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.IMAGE_VIEWER_CUSTOM_CMD, eO));
        HistoryMessage historyMessage = new HistoryMessage();
        historyMessage.Activity = this.mTbPageContext;
        historyMessage.threadId = cbVar.getId();
        historyMessage.threadName = cbVar.getTitle();
        historyMessage.forumName = cbVar.bnW();
        historyMessage.postID = cbVar.boi();
        MessageManager.getInstance().dispatchResponsedMessage(historyMessage);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.krJ != null && this.krJ.eLr != null) {
            if (view == this.krQ) {
                if (this.krJ.source == 1) {
                    cSD();
                } else {
                    bzn();
                }
                Mo("1");
            }
            if (view == this.krO || view == this.krP) {
                if (this.krJ.source == 1) {
                    cSD();
                } else {
                    bzn();
                }
                Mo("3");
            } else if (view == this.eKp) {
                cSE();
            } else {
                bzn();
                Mo("2");
            }
        }
    }

    private void cSE() {
        MetaData bnS;
        if (this.krJ != null && this.krJ.eLr != null) {
            cb cbVar = this.krJ.eLr;
            if (this.krJ.source == 1 && cbVar.bpx() != null) {
                bnS = cbVar.bpx().bnS();
            } else {
                bnS = cbVar.bnS();
            }
            if (bnS != null && !StringUtils.isNull(bnS.getName_show()) && !StringUtils.isNull(bnS.getUserId())) {
                long j = com.baidu.adp.lib.f.b.toLong(bnS.getUserId(), 0L);
                PersonPolymericActivityConfig createNormalConfig = new PersonPolymericActivityConfig(getContext()).createNormalConfig(j, j == com.baidu.adp.lib.f.b.toLong(TbadkCoreApplication.getCurrentAccount(), 0L), bnS.isBigV());
                createNormalConfig.setSourceTid(cbVar.getTid());
                createNormalConfig.setSourceNid(cbVar.bmq());
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, createNormalConfig));
            }
        }
    }

    private void Mo(String str) {
        TiebaStatic.log(new ar("c13356").dR("obj_locate", str).dR("tid", this.krJ.eLr.getTid()).v("topic_id", this.krJ.topicId).dR("obj_type", String.valueOf(this.krJ.source)));
    }
}
