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
/* loaded from: classes7.dex */
public class d extends com.baidu.tieba.card.a<com.baidu.tieba.homepage.topic.topicdetail.b.c> {
    private boolean Nj;
    private TextView bXF;
    private TbPageContext cRe;
    private ConstrainImageGroup fHq;
    private com.baidu.tieba.homepage.topic.topicdetail.b.c heX;
    private ClickableHeaderImageView heY;
    private ImageView heZ;
    private TextView hfa;
    private AgreeView hfb;
    private TextView hfc;
    private ImageView hfd;
    private TbRichTextView hfe;
    private RelativeLayout hff;
    private View hfg;
    private TbImageView hfh;
    private TextView hfi;
    private View mBottomLine;
    private int mSkinType;

    public d(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.Nj = true;
        this.mSkinType = 3;
        this.cRe = tbPageContext;
        initUI();
    }

    private void initUI() {
        View view = getView();
        this.heY = (ClickableHeaderImageView) view.findViewById(R.id.card_topic_detail_discuss_thread_user_header);
        this.heZ = (ImageView) view.findViewById(R.id.card_topic_detail_thread_opinion_img);
        this.bXF = (TextView) view.findViewById(R.id.card_topic_detail_discuss_thread_user_name);
        this.hfa = (TextView) view.findViewById(R.id.card_topic_detail_discuss_thread_forum_name);
        this.hfe = (TbRichTextView) view.findViewById(R.id.card_topic_detail_discuss_title);
        this.hfe.setClickable(true);
        this.hfe.setTextEllipsize(TextUtils.TruncateAt.END);
        this.hfe.setMaxLines(2);
        com.baidu.tbadk.widget.richText.a aVar = new com.baidu.tbadk.widget.richText.a();
        aVar.setTextSize(l.getDimens(getContext(), R.dimen.tbds44));
        aVar.setLineSpacing(l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds7), 1.0f);
        this.hfe.setLayoutStrategy(aVar);
        this.hff = (RelativeLayout) view.findViewById(R.id.topic_detail_img_container);
        this.fHq = (ConstrainImageGroup) view.findViewById(R.id.card_topic_detail_discuss_thread_img_layout);
        this.fHq.setImageMargin(TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds10));
        com.baidu.tbadk.widget.layout.a aVar2 = new com.baidu.tbadk.widget.layout.a(3);
        aVar2.h(1.0d);
        this.fHq.setImageProcessor(aVar2);
        this.hfb = (AgreeView) view.findViewById(R.id.card_topic_detail_discuss_argee_view);
        this.hfb.aFb();
        this.hfc = (TextView) view.findViewById(R.id.topic_comment_number);
        this.hfd = (ImageView) view.findViewById(R.id.topic_comment_pic);
        this.hfg = view.findViewById(R.id.card_topic_detail_discuss_original_thread_layout);
        this.hfh = (TbImageView) view.findViewById(R.id.card_topic_discuss_original_thread_pic);
        this.hfh.setRadius(l.getDimens(getContext(), R.dimen.tbds6));
        this.hfh.setConrers(5);
        this.hfh.setDrawCorner(true);
        this.hfi = (TextView) view.findViewById(R.id.card_topic_discuss_original_thread_title);
        this.mBottomLine = view.findViewById(R.id.card_topic_detail_discuss_line_layout);
        this.bXF.setOnClickListener(this);
        this.hfc.setOnClickListener(this);
        this.hfd.setOnClickListener(this);
        this.hfe.setOnClickListener(this);
        this.hfg.setOnClickListener(this);
        this.hfi.setOnClickListener(this);
    }

    public void setConstrainLayoutPool(com.baidu.adp.lib.d.b<ConstrainImageLayout> bVar) {
        if (this.fHq != null) {
            this.fHq.setConstrainLayoutPool(bVar);
        }
    }

    public void setConstrainImagePool(com.baidu.adp.lib.d.b<TbImageView> bVar) {
        if (this.fHq != null) {
            this.fHq.setImageViewPool(bVar);
        }
    }

    @Override // com.baidu.tieba.card.a
    public void setPreloadSizeReadyCallback(com.baidu.adp.widget.a.b bVar) {
        if (this.fHq != null) {
            this.fHq.setPreloadSizeReadyCallback(bVar);
        }
    }

    @Override // com.baidu.tieba.card.a
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i && this.heX != null) {
            this.mSkinType = i;
            this.heY.setIsNight(this.mSkinType == 1);
            if (this.heX.heh) {
                if (this.heX.heg == 1) {
                    am.setImageResource(this.heZ, R.drawable.label_topic_agree_red);
                    this.heY.setBorderColor(this.cRe.getPageActivity().getResources().getColor(R.color.cp_cont_h));
                } else if (this.heX.heg == 2) {
                    am.setImageResource(this.heZ, R.drawable.label_topic_disagree_blue);
                    this.heY.setBorderColor(this.cRe.getPageActivity().getResources().getColor(R.color.cp_link_tip_a));
                } else {
                    am.setImageResource(this.heZ, R.drawable.label_topic_eat_black);
                    this.heY.setBorderColor(this.cRe.getPageActivity().getResources().getColor(R.color.cp_cont_f));
                }
            }
            am.setViewTextColor(this.bXF, (int) R.color.cp_cont_b);
            am.setViewTextColor(this.hfa, (int) R.color.cp_cont_d);
            am.setViewTextColor(this.hfc, (int) R.color.cp_cont_j);
            if (this.hfd != null) {
                SvgManager.aEp().a(this.hfd, R.drawable.icon_pure_topic_reply16_svg, R.color.cp_cont_j, (SvgManager.SvgResourceStateType) null);
            }
            this.hfb.onChangeSkinType(i);
            this.hfe.setTextColor(am.getColor(R.color.cp_cont_b));
            am.c(this.hfg, l.getDimens(this.cRe.getPageActivity(), R.dimen.tbds6), R.color.cp_bg_line_j, R.color.cp_bg_line_j_alpha50);
            am.setViewTextColor(this.hfi, (int) R.color.cp_cont_d);
            this.fHq.onChangeSkinType();
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
        int azO;
        AgreeData aBM;
        if (cVar != null && cVar.cNb != null) {
            this.heX = cVar;
            onChangeSkinType(this.cRe, TbadkCoreApplication.getInst().getSkinType());
            bj bjVar = this.heX.cNb;
            PostData aBx = bjVar.aBx();
            if (aBx != null) {
                this.heY.setPlaceHolder(1);
                if (this.heX.source == 1) {
                    this.heY.setData(bjVar, false, true);
                } else {
                    this.heY.setData(bjVar, false, false);
                }
                this.heY.setIsRound(true);
                this.heY.setBorderWidth(2);
                this.heY.setDrawBorder(true);
                this.heY.setPageId(this.cRe.getUniqueId());
                if (this.heX.heh) {
                    this.heZ.setVisibility(0);
                    if (this.heX.heg == 1) {
                        this.heZ.setImageResource(R.drawable.label_topic_agree_red);
                        this.heY.setBorderColor(this.cRe.getPageActivity().getResources().getColor(R.color.cp_cont_h));
                    } else if (this.heX.heg == 2) {
                        this.heZ.setImageResource(R.drawable.label_topic_disagree_blue);
                        this.heY.setBorderColor(this.cRe.getPageActivity().getResources().getColor(R.color.cp_link_tip_a));
                    } else {
                        this.heZ.setImageResource(R.drawable.label_topic_eat_black);
                        this.heY.setBorderColor(this.cRe.getPageActivity().getResources().getColor(R.color.cp_cont_f));
                    }
                } else {
                    this.heZ.setVisibility(8);
                }
                if (this.heX.source == 1) {
                    name_show = aBx.azX().getName_show();
                    formatTime = aq.getFormatTime(aBx.getTime());
                    azO = aBx.cJB();
                } else {
                    name_show = bjVar.azX().getName_show();
                    formatTime = aq.getFormatTime(bjVar.getCreateTime());
                    azO = bjVar.azO();
                }
                if (!StringUtils.isNull(name_show)) {
                    this.bXF.setText(aq.cutChineseAndEnglishWithSuffix(name_show, 14, StringHelper.STRING_MORE));
                }
                if (StringUtils.isNull(bjVar.aAc())) {
                    this.hfa.setText(formatTime);
                } else {
                    this.hfa.setText(String.format(getContext().getString(R.string.daily_topic_discuss_forum_name), aq.cutChineseAndEnglishWithSuffix(bjVar.aAc(), 10, StringHelper.STRING_MORE), formatTime));
                }
                SvgManager.aEp().a(this.hfd, R.drawable.icon_pure_topic_reply16_svg, R.color.cp_cont_j, SvgManager.SvgResourceStateType.NORMAL_PRESS);
                String numFormatOverWan = aq.numFormatOverWan(azO);
                if (azO > 0) {
                    this.hfc.setVisibility(0);
                    this.hfc.setText(numFormatOverWan);
                } else {
                    this.hfc.setText(this.cRe.getString(R.string.action_comment_default));
                    this.hfc.setVisibility(0);
                }
                if (this.heX.source == 1) {
                    aBM = aBx.aBM();
                    aBM.objType = 1;
                } else {
                    aBM = bjVar.aBM();
                    aBM.objType = 3;
                }
                aBM.threadId = bjVar.getTid();
                this.hfb.setData(aBM);
                this.hfb.setTopicId(String.valueOf(this.heX.topicId));
                a(aBx, bjVar);
                a(cVar, bjVar);
                setPageUniqueId(getTag());
            }
        }
    }

    private void a(PostData postData, bj bjVar) {
        if (this.heX.source == 1) {
            this.hfe.setVisibility(0);
            this.hfe.setText(postData.cJz());
            return;
        }
        List<PbContent> azN = bjVar.azN();
        if (v.getCount(azN) > 0) {
            this.hfe.setVisibility(0);
            this.hfe.setText(TbRichTextView.a(getContext(), azN, false));
            return;
        }
        SpannableString aAP = bjVar.aAP();
        if (aAP != null && !StringUtils.isNull(aAP.toString())) {
            this.hfe.setVisibility(0);
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("type", "0");
                jSONObject.put("text", aAP);
            } catch (JSONException e) {
                e.printStackTrace();
            }
            JSONArray jSONArray = new JSONArray();
            jSONArray.put(jSONObject);
            this.hfe.setText(TbRichTextView.a(getContext(), jSONArray, false));
            return;
        }
        this.hfe.setVisibility(8);
    }

    private void a(com.baidu.tieba.homepage.topic.topicdetail.b.c cVar, bj bjVar) {
        if (this.heX.source == 1) {
            this.hfg.setVisibility(0);
            this.hff.setVisibility(8);
            String title = bjVar.getTitle();
            if (StringUtils.isNull(title)) {
                this.hfg.setVisibility(8);
                return;
            }
            this.hfg.setVisibility(0);
            this.hfi.setText(title);
            String str = null;
            if (v.getCount(bjVar.aAh()) != 0 && !v.isEmpty(cVar.cNb.aAh())) {
                Iterator<MediaData> it = cVar.cNb.aAh().iterator();
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
                am.setImageResource(this.hfh, R.drawable.pic_frs_topic_shareinone);
                return;
            }
            this.hfh.setPlaceHolder(1);
            this.hfh.startLoad(str, 10, false);
            return;
        }
        this.hfg.setVisibility(8);
        this.hff.setVisibility(0);
        b(cVar);
    }

    private void b(com.baidu.tieba.homepage.topic.topicdetail.b.c cVar) {
        final bj bjVar = cVar.cNb;
        ArrayList<MediaData> aAh = bjVar.aAh();
        if (i.axy().isShowImages() && v.getCount(aAh) != 0) {
            final LinkedList linkedList = new LinkedList();
            for (int i = 0; i < aAh.size(); i++) {
                MediaData mediaData = (MediaData) v.getItem(aAh, i);
                if (mediaData != null && mediaData.getType() == 3) {
                    linkedList.add(mediaData);
                }
            }
            if (v.getCount(linkedList) > 0) {
                this.hff.setVisibility(0);
                this.fHq.setFromCDN(this.Nj);
                this.fHq.setImageClickListener(new com.baidu.tbadk.widget.layout.d() { // from class: com.baidu.tieba.homepage.topic.topicdetail.view.d.1
                    @Override // com.baidu.tbadk.widget.layout.d
                    public void b(View view, int i2, boolean z) {
                        if (!z) {
                            d.this.a(view, linkedList, i2, bjVar);
                        } else {
                            d.this.aKa();
                        }
                    }
                });
                this.fHq.setImageMediaList(linkedList);
                return;
            }
            this.hff.setVisibility(8);
            return;
        }
        this.hff.setVisibility(8);
    }

    private void setPageUniqueId(BdUniqueId bdUniqueId) {
        setTag(bdUniqueId);
        if (this.fHq != null) {
            this.fHq.setPageUniqueId(bdUniqueId);
        }
    }

    public void aKa() {
        if (this.heX != null && this.heX.cNb != null) {
            PbActivityConfig addLocateParam = new PbActivityConfig(this.cRe.getPageActivity()).createFromThreadCfg(this.heX.cNb, null, "none", RequestResponseCode.REQUEST_FRS_TO_PB, true, false, false).addLocateParam(null);
            addLocateParam.setForumId(String.valueOf(this.heX.cNb.getFid()));
            addLocateParam.setFrom(PbActivityConfig.KEY_FROM_PERSONALIZE);
            addLocateParam.setForumName(this.heX.cNb.aAc());
            addLocateParam.setStartFrom(this.currentPageType);
            addLocateParam.setJumpGodReply(false);
            addLocateParam.setJumpToCommentArea(true);
            com.baidu.tieba.card.l.zC(this.heX.cNb.getTid());
            this.mTbPageContext.sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, addLocateParam));
        }
    }

    private void bNW() {
        PbActivityConfig createNormalCfg = new PbActivityConfig(this.cRe.getPageActivity()).createNormalCfg(String.valueOf(this.heX.cNb.getTid()), String.format("%1$s", this.heX.cNb.aBx().getId()) + "", 1, "mention");
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
                    imageUrlData.urlType = this.Nj ? 13 : 14;
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
        ImageViewerConfig createConfig = new ImageViewerConfig(this.mTbPageContext.getPageActivity()).createConfig(arrayList, i, bjVar.aAc(), String.valueOf(bjVar.getFid()), bjVar.getTid(), this.Nj, arrayList.size() > 0 ? arrayList.get(0) : "", true, concurrentHashMap, true);
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
        historyMessage.forumName = bjVar.aAc();
        historyMessage.postID = bjVar.aAn();
        MessageManager.getInstance().dispatchResponsedMessage(historyMessage);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.heX != null && this.heX.cNb != null) {
            if (view == this.hfe) {
                if (this.heX.source == 1) {
                    bNW();
                } else {
                    aKa();
                }
                BV("1");
            }
            if (view == this.hfc || view == this.hfd) {
                if (this.heX.source == 1) {
                    bNW();
                } else {
                    aKa();
                }
                BV("3");
            } else if (view == this.bXF) {
                bNX();
            } else {
                aKa();
                BV("2");
            }
        }
    }

    private void bNX() {
        MetaData azX;
        if (this.heX != null && this.heX.cNb != null) {
            bj bjVar = this.heX.cNb;
            if (this.heX.source == 1 && bjVar.aBx() != null) {
                azX = bjVar.aBx().azX();
            } else {
                azX = bjVar.azX();
            }
            if (azX != null && !StringUtils.isNull(azX.getName_show()) && !StringUtils.isNull(azX.getUserId())) {
                long j = com.baidu.adp.lib.f.b.toLong(azX.getUserId(), 0L);
                PersonPolymericActivityConfig createNormalConfig = new PersonPolymericActivityConfig(getContext()).createNormalConfig(j, j == com.baidu.adp.lib.f.b.toLong(TbadkCoreApplication.getCurrentAccount(), 0L), azX.isBigV());
                createNormalConfig.setSourceTid(bjVar.getTid());
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, createNormalConfig));
            }
        }
    }

    private void BV(String str) {
        TiebaStatic.log(new an("c13356").cp("obj_locate", str).cp("tid", this.heX.cNb.getTid()).s("topic_id", this.heX.topicId).cp("obj_type", String.valueOf(this.heX.source)));
    }
}
