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
import com.baidu.tbadk.core.data.bj;
import com.baidu.tbadk.core.i;
import com.baidu.tbadk.core.message.HistoryMessage;
import com.baidu.tbadk.core.util.SvgManager;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.util.v;
import com.baidu.tbadk.core.view.AgreeView;
import com.baidu.tbadk.core.view.ClickableHeaderImageView;
import com.baidu.tbadk.coreExtra.view.ImageUrlData;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tbadk.widget.layout.ConstrainImageGroup;
import com.baidu.tbadk.widget.layout.ConstrainImageLayout;
import com.baidu.tbadk.widget.richText.TbRichTextView;
import com.baidu.tieba.R;
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
/* loaded from: classes9.dex */
public class d extends com.baidu.tieba.card.a<com.baidu.tieba.homepage.topic.topicdetail.b.c> {
    private boolean agw;
    private TextView cBd;
    private TbPageContext duK;
    private ConstrainImageGroup gpx;
    private com.baidu.tieba.homepage.topic.topicdetail.b.c hSB;
    private ClickableHeaderImageView hSC;
    private ImageView hSD;
    private TextView hSE;
    private AgreeView hSF;
    private TextView hSG;
    private ImageView hSH;
    private TbRichTextView hSI;
    private RelativeLayout hSJ;
    private View hSK;
    private TbImageView hSL;
    private TextView hSM;
    private View mBottomLine;
    private int mSkinType;

    public d(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.agw = true;
        this.mSkinType = 3;
        this.duK = tbPageContext;
        initUI();
    }

    private void initUI() {
        View view = getView();
        this.hSC = (ClickableHeaderImageView) view.findViewById(R.id.card_topic_detail_discuss_thread_user_header);
        this.hSD = (ImageView) view.findViewById(R.id.card_topic_detail_thread_opinion_img);
        this.cBd = (TextView) view.findViewById(R.id.card_topic_detail_discuss_thread_user_name);
        this.hSE = (TextView) view.findViewById(R.id.card_topic_detail_discuss_thread_forum_name);
        this.hSI = (TbRichTextView) view.findViewById(R.id.card_topic_detail_discuss_title);
        this.hSI.setClickable(true);
        this.hSI.setTextEllipsize(TextUtils.TruncateAt.END);
        this.hSI.setMaxLines(2);
        com.baidu.tbadk.widget.richText.a aVar = new com.baidu.tbadk.widget.richText.a();
        aVar.setTextSize(l.getDimens(getContext(), R.dimen.tbds44));
        aVar.setLineSpacing(l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds7), 1.0f);
        this.hSI.setLayoutStrategy(aVar);
        this.hSJ = (RelativeLayout) view.findViewById(R.id.topic_detail_img_container);
        this.gpx = (ConstrainImageGroup) view.findViewById(R.id.card_topic_detail_discuss_thread_img_layout);
        this.gpx.setImageMargin(TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds10));
        com.baidu.tbadk.widget.layout.a aVar2 = new com.baidu.tbadk.widget.layout.a(3);
        aVar2.n(1.0d);
        this.gpx.setImageProcessor(aVar2);
        this.hSF = (AgreeView) view.findViewById(R.id.card_topic_detail_discuss_argee_view);
        this.hSF.aPJ();
        this.hSG = (TextView) view.findViewById(R.id.topic_comment_number);
        this.hSH = (ImageView) view.findViewById(R.id.topic_comment_pic);
        this.hSK = view.findViewById(R.id.card_topic_detail_discuss_original_thread_layout);
        this.hSL = (TbImageView) view.findViewById(R.id.card_topic_discuss_original_thread_pic);
        this.hSL.setRadius(l.getDimens(getContext(), R.dimen.tbds6));
        this.hSL.setConrers(5);
        this.hSL.setDrawCorner(true);
        this.hSM = (TextView) view.findViewById(R.id.card_topic_discuss_original_thread_title);
        this.mBottomLine = view.findViewById(R.id.card_topic_detail_discuss_line_layout);
        this.cBd.setOnClickListener(this);
        this.hSG.setOnClickListener(this);
        this.hSH.setOnClickListener(this);
        this.hSI.setOnClickListener(this);
        this.hSK.setOnClickListener(this);
        this.hSM.setOnClickListener(this);
    }

    public void setConstrainLayoutPool(com.baidu.adp.lib.d.b<ConstrainImageLayout> bVar) {
        if (this.gpx != null) {
            this.gpx.setConstrainLayoutPool(bVar);
        }
    }

    public void setConstrainImagePool(com.baidu.adp.lib.d.b<TbImageView> bVar) {
        if (this.gpx != null) {
            this.gpx.setImageViewPool(bVar);
        }
    }

    @Override // com.baidu.tieba.card.a
    public void setPreloadSizeReadyCallback(com.baidu.adp.widget.a.b bVar) {
        if (this.gpx != null) {
            this.gpx.setPreloadSizeReadyCallback(bVar);
        }
    }

    @Override // com.baidu.tieba.card.a
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i && this.hSB != null) {
            this.mSkinType = i;
            this.hSC.setIsNight(this.mSkinType == 1);
            if (this.hSB.hRM) {
                if (this.hSB.hRL == 1) {
                    am.setImageResource(this.hSD, R.drawable.label_topic_agree_red);
                    this.hSC.setBorderColor(this.duK.getPageActivity().getResources().getColor(R.color.cp_cont_h));
                } else if (this.hSB.hRL == 2) {
                    am.setImageResource(this.hSD, R.drawable.label_topic_disagree_blue);
                    this.hSC.setBorderColor(this.duK.getPageActivity().getResources().getColor(R.color.cp_link_tip_a));
                } else {
                    am.setImageResource(this.hSD, R.drawable.label_topic_eat_black);
                    this.hSC.setBorderColor(this.duK.getPageActivity().getResources().getColor(R.color.cp_cont_f));
                }
            }
            am.setViewTextColor(this.cBd, (int) R.color.cp_cont_b);
            am.setViewTextColor(this.hSE, (int) R.color.cp_cont_d);
            am.setViewTextColor(this.hSG, (int) R.color.cp_cont_j);
            if (this.hSH != null) {
                SvgManager.aOR().a(this.hSH, R.drawable.icon_pure_topic_reply16_svg, R.color.cp_cont_j, (SvgManager.SvgResourceStateType) null);
            }
            this.hSF.onChangeSkinType(i);
            this.hSI.setTextColor(am.getColor(R.color.cp_cont_b));
            am.c(this.hSK, l.getDimens(this.duK.getPageActivity(), R.dimen.tbds6), R.color.cp_bg_line_j, R.color.cp_bg_line_j_alpha50);
            am.setViewTextColor(this.hSM, (int) R.color.cp_cont_d);
            this.gpx.onChangeSkinType();
            am.setBackgroundColor(this.mBottomLine, R.color.cp_bg_line_e);
        }
    }

    @Override // com.baidu.tieba.card.a
    public int getLayout() {
        return R.layout.topic_discuss_view;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.a
    public void a(com.baidu.tieba.homepage.topic.topicdetail.b.c cVar) {
        String name_show;
        String formatTime;
        int aKt;
        AgreeData aMq;
        if (cVar != null && cVar.dqE != null) {
            this.hSB = cVar;
            onChangeSkinType(this.duK, TbadkCoreApplication.getInst().getSkinType());
            bj bjVar = this.hSB.dqE;
            PostData aMc = bjVar.aMc();
            if (aMc != null) {
                this.hSC.setPlaceHolder(1);
                if (this.hSB.source == 1) {
                    this.hSC.setData(bjVar, false, true);
                } else {
                    this.hSC.setData(bjVar, false, false);
                }
                this.hSC.setIsRound(true);
                this.hSC.setBorderWidth(2);
                this.hSC.setDrawBorder(true);
                this.hSC.setPageId(this.duK.getUniqueId());
                if (this.hSB.hRM) {
                    this.hSD.setVisibility(0);
                    if (this.hSB.hRL == 1) {
                        this.hSD.setImageResource(R.drawable.label_topic_agree_red);
                        this.hSC.setBorderColor(this.duK.getPageActivity().getResources().getColor(R.color.cp_cont_h));
                    } else if (this.hSB.hRL == 2) {
                        this.hSD.setImageResource(R.drawable.label_topic_disagree_blue);
                        this.hSC.setBorderColor(this.duK.getPageActivity().getResources().getColor(R.color.cp_link_tip_a));
                    } else {
                        this.hSD.setImageResource(R.drawable.label_topic_eat_black);
                        this.hSC.setBorderColor(this.duK.getPageActivity().getResources().getColor(R.color.cp_cont_f));
                    }
                } else {
                    this.hSD.setVisibility(8);
                }
                if (this.hSB.source == 1) {
                    name_show = aMc.aKC().getName_show();
                    formatTime = aq.getFormatTime(aMc.getTime());
                    aKt = aMc.cWs();
                } else {
                    name_show = bjVar.aKC().getName_show();
                    formatTime = aq.getFormatTime(bjVar.getCreateTime());
                    aKt = bjVar.aKt();
                }
                if (!StringUtils.isNull(name_show)) {
                    this.cBd.setText(aq.cutChineseAndEnglishWithSuffix(name_show, 14, StringHelper.STRING_MORE));
                }
                if (StringUtils.isNull(bjVar.aKH())) {
                    this.hSE.setText(formatTime);
                } else {
                    this.hSE.setText(String.format(getContext().getString(R.string.daily_topic_discuss_forum_name), aq.cutChineseAndEnglishWithSuffix(bjVar.aKH(), 10, StringHelper.STRING_MORE), formatTime));
                }
                SvgManager.aOR().a(this.hSH, R.drawable.icon_pure_topic_reply16_svg, R.color.cp_cont_j, SvgManager.SvgResourceStateType.NORMAL_PRESS);
                String numFormatOverWan = aq.numFormatOverWan(aKt);
                if (aKt > 0) {
                    this.hSG.setVisibility(0);
                    this.hSG.setText(numFormatOverWan);
                } else {
                    this.hSG.setText(this.duK.getString(R.string.action_comment_default));
                    this.hSG.setVisibility(0);
                }
                if (this.hSB.source == 1) {
                    aMq = aMc.aMq();
                    aMq.objType = 1;
                } else {
                    aMq = bjVar.aMq();
                    aMq.objType = 3;
                }
                aMq.threadId = bjVar.getTid();
                this.hSF.setData(aMq);
                this.hSF.setTopicId(String.valueOf(this.hSB.topicId));
                a(aMc, bjVar);
                a(cVar, bjVar);
                setPageUniqueId(getTag());
            }
        }
    }

    private void a(PostData postData, bj bjVar) {
        if (this.hSB.source == 1) {
            this.hSI.setVisibility(0);
            this.hSI.setText(postData.cWq());
            return;
        }
        List<PbContent> aKs = bjVar.aKs();
        if (v.getCount(aKs) > 0) {
            this.hSI.setVisibility(0);
            this.hSI.setText(TbRichTextView.a(getContext(), aKs, false));
            return;
        }
        SpannableString aLu = bjVar.aLu();
        if (aLu != null && !StringUtils.isNull(aLu.toString())) {
            this.hSI.setVisibility(0);
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("type", "0");
                jSONObject.put("text", aLu);
            } catch (JSONException e) {
                e.printStackTrace();
            }
            JSONArray jSONArray = new JSONArray();
            jSONArray.put(jSONObject);
            this.hSI.setText(TbRichTextView.a(getContext(), jSONArray, false));
            return;
        }
        this.hSI.setVisibility(8);
    }

    private void a(com.baidu.tieba.homepage.topic.topicdetail.b.c cVar, bj bjVar) {
        if (this.hSB.source == 1) {
            this.hSK.setVisibility(0);
            this.hSJ.setVisibility(8);
            String title = bjVar.getTitle();
            if (StringUtils.isNull(title)) {
                this.hSK.setVisibility(8);
                return;
            }
            this.hSK.setVisibility(0);
            this.hSM.setText(title);
            String str = null;
            if (v.getCount(bjVar.aKM()) != 0 && !v.isEmpty(cVar.dqE.aKM())) {
                Iterator<MediaData> it = cVar.dqE.aKM().iterator();
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
                am.setImageResource(this.hSL, R.drawable.pic_frs_topic_shareinone);
                return;
            }
            this.hSL.setPlaceHolder(1);
            this.hSL.startLoad(str, 10, false);
            return;
        }
        this.hSK.setVisibility(8);
        this.hSJ.setVisibility(0);
        b(cVar);
    }

    private void b(com.baidu.tieba.homepage.topic.topicdetail.b.c cVar) {
        final bj bjVar = cVar.dqE;
        ArrayList<MediaData> aKM = bjVar.aKM();
        if (i.aIc().isShowImages() && v.getCount(aKM) != 0) {
            final LinkedList linkedList = new LinkedList();
            for (int i = 0; i < aKM.size(); i++) {
                MediaData mediaData = (MediaData) v.getItem(aKM, i);
                if (mediaData != null && mediaData.getType() == 3) {
                    linkedList.add(mediaData);
                }
            }
            if (v.getCount(linkedList) > 0) {
                this.hSJ.setVisibility(0);
                this.gpx.setFromCDN(this.agw);
                this.gpx.setImageClickListener(new com.baidu.tbadk.widget.layout.d() { // from class: com.baidu.tieba.homepage.topic.topicdetail.view.d.1
                    @Override // com.baidu.tbadk.widget.layout.d
                    public void b(View view, int i2, boolean z) {
                        if (!z) {
                            d.this.a(view, linkedList, i2, bjVar);
                        } else {
                            d.this.aUY();
                        }
                    }
                });
                this.gpx.setImageMediaList(linkedList);
                return;
            }
            this.hSJ.setVisibility(8);
            return;
        }
        this.hSJ.setVisibility(8);
    }

    private void setPageUniqueId(BdUniqueId bdUniqueId) {
        setTag(bdUniqueId);
        if (this.gpx != null) {
            this.gpx.setPageUniqueId(bdUniqueId);
        }
    }

    public void aUY() {
        if (this.hSB != null && this.hSB.dqE != null) {
            PbActivityConfig addLocateParam = new PbActivityConfig(this.duK.getPageActivity()).createFromThreadCfg(this.hSB.dqE, null, "none", RequestResponseCode.REQUEST_FRS_TO_PB, true, false, false).addLocateParam(null);
            addLocateParam.setForumId(String.valueOf(this.hSB.dqE.getFid()));
            addLocateParam.setFrom(PbActivityConfig.KEY_FROM_PERSONALIZE);
            addLocateParam.setForumName(this.hSB.dqE.aKH());
            addLocateParam.setStartFrom(this.currentPageType);
            addLocateParam.setJumpGodReply(false);
            addLocateParam.setJumpToCommentArea(true);
            com.baidu.tieba.card.l.BE(this.hSB.dqE.getTid());
            this.mTbPageContext.sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, addLocateParam));
        }
    }

    private void car() {
        PbActivityConfig createNormalCfg = new PbActivityConfig(this.duK.getPageActivity()).createNormalCfg(String.valueOf(this.hSB.dqE.getTid()), String.format("%1$s", this.hSB.dqE.aMc().getId()) + "", 1, "mention");
        createNormalCfg.setStartFrom(12);
        createNormalCfg.setJumpToCommentArea(true);
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, createNormalCfg));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(View view, List<MediaData> list, int i, bj bjVar) {
        if (!TbadkCoreApplication.getInst().appResponseToCmd(CmdConfigCustom.IMAGE_VIEWER_CUSTOM_CMD)) {
            l.showToast(this.mTbPageContext.getPageActivity(), (int) R.string.plugin_image_viewer_install_error_tips);
            return;
        }
        ArrayList<String> arrayList = new ArrayList<>();
        ConcurrentHashMap<String, ImageUrlData> concurrentHashMap = new ConcurrentHashMap<>();
        for (MediaData mediaData : list) {
            if (!TextUtils.isEmpty(mediaData.getSrc_pic())) {
                arrayList.add(mediaData.getSrc_pic());
                if (!TextUtils.isEmpty(mediaData.getPicUrl())) {
                    ImageUrlData imageUrlData = new ImageUrlData();
                    imageUrlData.urlType = this.agw ? 13 : 14;
                    imageUrlData.imageUrl = mediaData.getPicUrl();
                    imageUrlData.originalUrl = mediaData.getOriginalUrl();
                    imageUrlData.originalSize = mediaData.getOriginalSize();
                    imageUrlData.isLongPic = mediaData.isLongPic();
                    imageUrlData.mIsShowOrigonButton = mediaData.isShowOriginBtn();
                    imageUrlData.threadId = com.baidu.adp.lib.f.b.toLong(bjVar.getTid(), -1L);
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
        ImageViewerConfig createConfig = new ImageViewerConfig(this.mTbPageContext.getPageActivity()).createConfig(arrayList, i, bjVar.aKH(), String.valueOf(bjVar.getFid()), bjVar.getTid(), this.agw, arrayList.size() > 0 ? arrayList.get(0) : "", true, concurrentHashMap, true);
        if (this.currentPageType == 2) {
            createConfig.getIntent().putExtra("from", "index");
        } else {
            createConfig.getIntent().putExtra("from", "other");
        }
        Rect rect = new Rect();
        view.getGlobalVisibleRect(rect);
        createConfig.setSrcRectInScreen(rect, UtilHelper.fixedDrawableRect(rect, view));
        createConfig.setThreadData(bjVar);
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.IMAGE_VIEWER_CUSTOM_CMD, createConfig));
        HistoryMessage historyMessage = new HistoryMessage();
        historyMessage.Activity = this.mTbPageContext;
        historyMessage.threadId = bjVar.getId();
        historyMessage.threadName = bjVar.getTitle();
        historyMessage.forumName = bjVar.aKH();
        historyMessage.postID = bjVar.aKS();
        MessageManager.getInstance().dispatchResponsedMessage(historyMessage);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.hSB != null && this.hSB.dqE != null) {
            if (view == this.hSI) {
                if (this.hSB.source == 1) {
                    car();
                } else {
                    aUY();
                }
                DX("1");
            }
            if (view == this.hSG || view == this.hSH) {
                if (this.hSB.source == 1) {
                    car();
                } else {
                    aUY();
                }
                DX("3");
            } else if (view == this.cBd) {
                cas();
            } else {
                aUY();
                DX("2");
            }
        }
    }

    private void cas() {
        MetaData aKC;
        if (this.hSB != null && this.hSB.dqE != null) {
            bj bjVar = this.hSB.dqE;
            if (this.hSB.source == 1 && bjVar.aMc() != null) {
                aKC = bjVar.aMc().aKC();
            } else {
                aKC = bjVar.aKC();
            }
            if (aKC != null && !StringUtils.isNull(aKC.getName_show()) && !StringUtils.isNull(aKC.getUserId())) {
                long j = com.baidu.adp.lib.f.b.toLong(aKC.getUserId(), 0L);
                PersonPolymericActivityConfig createNormalConfig = new PersonPolymericActivityConfig(getContext()).createNormalConfig(j, j == com.baidu.adp.lib.f.b.toLong(TbadkCoreApplication.getCurrentAccount(), 0L), aKC.isBigV());
                createNormalConfig.setSourceTid(bjVar.getTid());
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, createNormalConfig));
            }
        }
    }

    private void DX(String str) {
        TiebaStatic.log(new an("c13356").cI("obj_locate", str).cI("tid", this.hSB.dqE.getTid()).t("topic_id", this.hSB.topicId).cI("obj_type", String.valueOf(this.hSB.source)));
    }
}
