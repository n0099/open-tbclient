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
/* loaded from: classes6.dex */
public class d extends com.baidu.tieba.card.a<com.baidu.tieba.homepage.topic.topicdetail.b.c> {
    private boolean Nf;
    private TextView bXt;
    private TbPageContext cQU;
    private ConstrainImageGroup fEg;
    private ImageView hbA;
    private TbRichTextView hbB;
    private RelativeLayout hbC;
    private View hbD;
    private TbImageView hbE;
    private TextView hbF;
    private com.baidu.tieba.homepage.topic.topicdetail.b.c hbu;
    private ClickableHeaderImageView hbv;
    private ImageView hbw;
    private TextView hbx;
    private AgreeView hby;
    private TextView hbz;
    private View mBottomLine;
    private int mSkinType;

    public d(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.Nf = true;
        this.mSkinType = 3;
        this.cQU = tbPageContext;
        initUI();
    }

    private void initUI() {
        View view = getView();
        this.hbv = (ClickableHeaderImageView) view.findViewById(R.id.card_topic_detail_discuss_thread_user_header);
        this.hbw = (ImageView) view.findViewById(R.id.card_topic_detail_thread_opinion_img);
        this.bXt = (TextView) view.findViewById(R.id.card_topic_detail_discuss_thread_user_name);
        this.hbx = (TextView) view.findViewById(R.id.card_topic_detail_discuss_thread_forum_name);
        this.hbB = (TbRichTextView) view.findViewById(R.id.card_topic_detail_discuss_title);
        this.hbB.setClickable(true);
        this.hbB.setTextEllipsize(TextUtils.TruncateAt.END);
        this.hbB.setMaxLines(2);
        com.baidu.tbadk.widget.richText.a aVar = new com.baidu.tbadk.widget.richText.a();
        aVar.setTextSize(l.getDimens(getContext(), R.dimen.tbds44));
        aVar.setLineSpacing(l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds7), 1.0f);
        this.hbB.setLayoutStrategy(aVar);
        this.hbC = (RelativeLayout) view.findViewById(R.id.topic_detail_img_container);
        this.fEg = (ConstrainImageGroup) view.findViewById(R.id.card_topic_detail_discuss_thread_img_layout);
        this.fEg.setImageMargin(TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds10));
        com.baidu.tbadk.widget.layout.a aVar2 = new com.baidu.tbadk.widget.layout.a(3);
        aVar2.h(1.0d);
        this.fEg.setImageProcessor(aVar2);
        this.hby = (AgreeView) view.findViewById(R.id.card_topic_detail_discuss_argee_view);
        this.hby.aEI();
        this.hbz = (TextView) view.findViewById(R.id.topic_comment_number);
        this.hbA = (ImageView) view.findViewById(R.id.topic_comment_pic);
        this.hbD = view.findViewById(R.id.card_topic_detail_discuss_original_thread_layout);
        this.hbE = (TbImageView) view.findViewById(R.id.card_topic_discuss_original_thread_pic);
        this.hbE.setRadius(l.getDimens(getContext(), R.dimen.tbds6));
        this.hbE.setConrers(5);
        this.hbE.setDrawCorner(true);
        this.hbF = (TextView) view.findViewById(R.id.card_topic_discuss_original_thread_title);
        this.mBottomLine = view.findViewById(R.id.card_topic_detail_discuss_line_layout);
        this.bXt.setOnClickListener(this);
        this.hbz.setOnClickListener(this);
        this.hbA.setOnClickListener(this);
        this.hbB.setOnClickListener(this);
        this.hbD.setOnClickListener(this);
        this.hbF.setOnClickListener(this);
    }

    public void setConstrainLayoutPool(com.baidu.adp.lib.d.b<ConstrainImageLayout> bVar) {
        if (this.fEg != null) {
            this.fEg.setConstrainLayoutPool(bVar);
        }
    }

    public void setConstrainImagePool(com.baidu.adp.lib.d.b<TbImageView> bVar) {
        if (this.fEg != null) {
            this.fEg.setImageViewPool(bVar);
        }
    }

    @Override // com.baidu.tieba.card.a
    public void setPreloadSizeReadyCallback(com.baidu.adp.widget.a.b bVar) {
        if (this.fEg != null) {
            this.fEg.setPreloadSizeReadyCallback(bVar);
        }
    }

    @Override // com.baidu.tieba.card.a
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i && this.hbu != null) {
            this.mSkinType = i;
            this.hbv.setIsNight(this.mSkinType == 1);
            if (this.hbu.haE) {
                if (this.hbu.haD == 1) {
                    am.setImageResource(this.hbw, R.drawable.label_topic_agree_red);
                    this.hbv.setBorderColor(this.cQU.getPageActivity().getResources().getColor(R.color.cp_cont_h));
                } else if (this.hbu.haD == 2) {
                    am.setImageResource(this.hbw, R.drawable.label_topic_disagree_blue);
                    this.hbv.setBorderColor(this.cQU.getPageActivity().getResources().getColor(R.color.cp_link_tip_a));
                } else {
                    am.setImageResource(this.hbw, R.drawable.label_topic_eat_black);
                    this.hbv.setBorderColor(this.cQU.getPageActivity().getResources().getColor(R.color.cp_cont_f));
                }
            }
            am.setViewTextColor(this.bXt, (int) R.color.cp_cont_b);
            am.setViewTextColor(this.hbx, (int) R.color.cp_cont_d);
            am.setViewTextColor(this.hbz, (int) R.color.cp_cont_j);
            if (this.hbA != null) {
                SvgManager.aDW().a(this.hbA, R.drawable.icon_pure_topic_reply16_svg, R.color.cp_cont_j, (SvgManager.SvgResourceStateType) null);
            }
            this.hby.onChangeSkinType(i);
            this.hbB.setTextColor(am.getColor(R.color.cp_cont_b));
            am.c(this.hbD, l.getDimens(this.cQU.getPageActivity(), R.dimen.tbds6), R.color.cp_bg_line_j, R.color.cp_bg_line_j_alpha50);
            am.setViewTextColor(this.hbF, (int) R.color.cp_cont_d);
            this.fEg.onChangeSkinType();
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
        int azv;
        AgreeData aBt;
        if (cVar != null && cVar.cMR != null) {
            this.hbu = cVar;
            onChangeSkinType(this.cQU, TbadkCoreApplication.getInst().getSkinType());
            bj bjVar = this.hbu.cMR;
            PostData aBe = bjVar.aBe();
            if (aBe != null) {
                this.hbv.setPlaceHolder(1);
                if (this.hbu.source == 1) {
                    this.hbv.setData(bjVar, false, true);
                } else {
                    this.hbv.setData(bjVar, false, false);
                }
                this.hbv.setIsRound(true);
                this.hbv.setBorderWidth(2);
                this.hbv.setDrawBorder(true);
                this.hbv.setPageId(this.cQU.getUniqueId());
                if (this.hbu.haE) {
                    this.hbw.setVisibility(0);
                    if (this.hbu.haD == 1) {
                        this.hbw.setImageResource(R.drawable.label_topic_agree_red);
                        this.hbv.setBorderColor(this.cQU.getPageActivity().getResources().getColor(R.color.cp_cont_h));
                    } else if (this.hbu.haD == 2) {
                        this.hbw.setImageResource(R.drawable.label_topic_disagree_blue);
                        this.hbv.setBorderColor(this.cQU.getPageActivity().getResources().getColor(R.color.cp_link_tip_a));
                    } else {
                        this.hbw.setImageResource(R.drawable.label_topic_eat_black);
                        this.hbv.setBorderColor(this.cQU.getPageActivity().getResources().getColor(R.color.cp_cont_f));
                    }
                } else {
                    this.hbw.setVisibility(8);
                }
                if (this.hbu.source == 1) {
                    name_show = aBe.azE().getName_show();
                    formatTime = aq.getFormatTime(aBe.getTime());
                    azv = aBe.cIx();
                } else {
                    name_show = bjVar.azE().getName_show();
                    formatTime = aq.getFormatTime(bjVar.getCreateTime());
                    azv = bjVar.azv();
                }
                if (!StringUtils.isNull(name_show)) {
                    this.bXt.setText(aq.cutChineseAndEnglishWithSuffix(name_show, 14, StringHelper.STRING_MORE));
                }
                if (StringUtils.isNull(bjVar.azJ())) {
                    this.hbx.setText(formatTime);
                } else {
                    this.hbx.setText(String.format(getContext().getString(R.string.daily_topic_discuss_forum_name), aq.cutChineseAndEnglishWithSuffix(bjVar.azJ(), 10, StringHelper.STRING_MORE), formatTime));
                }
                SvgManager.aDW().a(this.hbA, R.drawable.icon_pure_topic_reply16_svg, R.color.cp_cont_j, SvgManager.SvgResourceStateType.NORMAL_PRESS);
                String numFormatOverWan = aq.numFormatOverWan(azv);
                if (azv > 0) {
                    this.hbz.setVisibility(0);
                    this.hbz.setText(numFormatOverWan);
                } else {
                    this.hbz.setText(this.cQU.getString(R.string.action_comment_default));
                    this.hbz.setVisibility(0);
                }
                if (this.hbu.source == 1) {
                    aBt = aBe.aBt();
                    aBt.objType = 1;
                } else {
                    aBt = bjVar.aBt();
                    aBt.objType = 3;
                }
                aBt.threadId = bjVar.getTid();
                this.hby.setData(aBt);
                this.hby.setTopicId(String.valueOf(this.hbu.topicId));
                a(aBe, bjVar);
                a(cVar, bjVar);
                setPageUniqueId(getTag());
            }
        }
    }

    private void a(PostData postData, bj bjVar) {
        if (this.hbu.source == 1) {
            this.hbB.setVisibility(0);
            this.hbB.setText(postData.cIv());
            return;
        }
        List<PbContent> azu = bjVar.azu();
        if (v.getCount(azu) > 0) {
            this.hbB.setVisibility(0);
            this.hbB.setText(TbRichTextView.a(getContext(), azu, false));
            return;
        }
        SpannableString aAw = bjVar.aAw();
        if (aAw != null && !StringUtils.isNull(aAw.toString())) {
            this.hbB.setVisibility(0);
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("type", "0");
                jSONObject.put("text", aAw);
            } catch (JSONException e) {
                e.printStackTrace();
            }
            JSONArray jSONArray = new JSONArray();
            jSONArray.put(jSONObject);
            this.hbB.setText(TbRichTextView.a(getContext(), jSONArray, false));
            return;
        }
        this.hbB.setVisibility(8);
    }

    private void a(com.baidu.tieba.homepage.topic.topicdetail.b.c cVar, bj bjVar) {
        if (this.hbu.source == 1) {
            this.hbD.setVisibility(0);
            this.hbC.setVisibility(8);
            String title = bjVar.getTitle();
            if (StringUtils.isNull(title)) {
                this.hbD.setVisibility(8);
                return;
            }
            this.hbD.setVisibility(0);
            this.hbF.setText(title);
            String str = null;
            if (v.getCount(bjVar.azO()) != 0 && !v.isEmpty(cVar.cMR.azO())) {
                Iterator<MediaData> it = cVar.cMR.azO().iterator();
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
                am.setImageResource(this.hbE, R.drawable.pic_frs_topic_shareinone);
                return;
            }
            this.hbE.setPlaceHolder(1);
            this.hbE.startLoad(str, 10, false);
            return;
        }
        this.hbD.setVisibility(8);
        this.hbC.setVisibility(0);
        b(cVar);
    }

    private void b(com.baidu.tieba.homepage.topic.topicdetail.b.c cVar) {
        final bj bjVar = cVar.cMR;
        ArrayList<MediaData> azO = bjVar.azO();
        if (i.axf().isShowImages() && v.getCount(azO) != 0) {
            final LinkedList linkedList = new LinkedList();
            for (int i = 0; i < azO.size(); i++) {
                MediaData mediaData = (MediaData) v.getItem(azO, i);
                if (mediaData != null && mediaData.getType() == 3) {
                    linkedList.add(mediaData);
                }
            }
            if (v.getCount(linkedList) > 0) {
                this.hbC.setVisibility(0);
                this.fEg.setFromCDN(this.Nf);
                this.fEg.setImageClickListener(new com.baidu.tbadk.widget.layout.d() { // from class: com.baidu.tieba.homepage.topic.topicdetail.view.d.1
                    @Override // com.baidu.tbadk.widget.layout.d
                    public void b(View view, int i2, boolean z) {
                        if (!z) {
                            d.this.a(view, linkedList, i2, bjVar);
                        } else {
                            d.this.aJG();
                        }
                    }
                });
                this.fEg.setImageMediaList(linkedList);
                return;
            }
            this.hbC.setVisibility(8);
            return;
        }
        this.hbC.setVisibility(8);
    }

    private void setPageUniqueId(BdUniqueId bdUniqueId) {
        setTag(bdUniqueId);
        if (this.fEg != null) {
            this.fEg.setPageUniqueId(bdUniqueId);
        }
    }

    public void aJG() {
        if (this.hbu != null && this.hbu.cMR != null) {
            PbActivityConfig addLocateParam = new PbActivityConfig(this.cQU.getPageActivity()).createFromThreadCfg(this.hbu.cMR, null, "none", RequestResponseCode.REQUEST_FRS_TO_PB, true, false, false).addLocateParam(null);
            addLocateParam.setForumId(String.valueOf(this.hbu.cMR.getFid()));
            addLocateParam.setFrom(PbActivityConfig.KEY_FROM_PERSONALIZE);
            addLocateParam.setForumName(this.hbu.cMR.azJ());
            addLocateParam.setStartFrom(this.currentPageType);
            addLocateParam.setJumpGodReply(false);
            addLocateParam.setJumpToCommentArea(true);
            com.baidu.tieba.card.l.zs(this.hbu.cMR.getTid());
            this.mTbPageContext.sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, addLocateParam));
        }
    }

    private void bMO() {
        PbActivityConfig createNormalCfg = new PbActivityConfig(this.cQU.getPageActivity()).createNormalCfg(String.valueOf(this.hbu.cMR.getTid()), String.format("%1$s", this.hbu.cMR.aBe().getId()) + "", 1, "mention");
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
                    imageUrlData.urlType = this.Nf ? 13 : 14;
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
        ImageViewerConfig createConfig = new ImageViewerConfig(this.mTbPageContext.getPageActivity()).createConfig(arrayList, i, bjVar.azJ(), String.valueOf(bjVar.getFid()), bjVar.getTid(), this.Nf, arrayList.size() > 0 ? arrayList.get(0) : "", true, concurrentHashMap, true);
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
        historyMessage.forumName = bjVar.azJ();
        historyMessage.postID = bjVar.azU();
        MessageManager.getInstance().dispatchResponsedMessage(historyMessage);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.hbu != null && this.hbu.cMR != null) {
            if (view == this.hbB) {
                if (this.hbu.source == 1) {
                    bMO();
                } else {
                    aJG();
                }
                BL("1");
            }
            if (view == this.hbz || view == this.hbA) {
                if (this.hbu.source == 1) {
                    bMO();
                } else {
                    aJG();
                }
                BL("3");
            } else if (view == this.bXt) {
                bMP();
            } else {
                aJG();
                BL("2");
            }
        }
    }

    private void bMP() {
        MetaData azE;
        if (this.hbu != null && this.hbu.cMR != null) {
            bj bjVar = this.hbu.cMR;
            if (this.hbu.source == 1 && bjVar.aBe() != null) {
                azE = bjVar.aBe().azE();
            } else {
                azE = bjVar.azE();
            }
            if (azE != null && !StringUtils.isNull(azE.getName_show()) && !StringUtils.isNull(azE.getUserId())) {
                long j = com.baidu.adp.lib.f.b.toLong(azE.getUserId(), 0L);
                PersonPolymericActivityConfig createNormalConfig = new PersonPolymericActivityConfig(getContext()).createNormalConfig(j, j == com.baidu.adp.lib.f.b.toLong(TbadkCoreApplication.getCurrentAccount(), 0L), azE.isBigV());
                createNormalConfig.setSourceTid(bjVar.getTid());
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, createNormalConfig));
            }
        }
    }

    private void BL(String str) {
        TiebaStatic.log(new an("c13356").cp("obj_locate", str).cp("tid", this.hbu.cMR.getTid()).s("topic_id", this.hbu.topicId).cp("obj_type", String.valueOf(this.hbu.source)));
    }
}
