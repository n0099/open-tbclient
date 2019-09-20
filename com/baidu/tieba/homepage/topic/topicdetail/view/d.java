package com.baidu.tieba.homepage.topic.topicdetail.view;

import android.graphics.Rect;
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
import com.baidu.mobads.interfaces.utils.IXAdSystemUtils;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.ChannelHomeActivityConfig;
import com.baidu.tbadk.core.atomData.ImageViewerConfig;
import com.baidu.tbadk.core.atomData.PbActivityConfig;
import com.baidu.tbadk.core.atomData.PersonPolymericActivityConfig;
import com.baidu.tbadk.core.data.MediaData;
import com.baidu.tbadk.core.data.MetaData;
import com.baidu.tbadk.core.data.bh;
import com.baidu.tbadk.core.i;
import com.baidu.tbadk.core.message.HistoryMessage;
import com.baidu.tbadk.core.util.SvgManager;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.util.v;
import com.baidu.tbadk.core.view.AgreeAloneView;
import com.baidu.tbadk.core.view.ClickableHeaderImageView;
import com.baidu.tbadk.coreExtra.view.ImageUrlData;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tbadk.widget.layout.ConstrainImageGroup;
import com.baidu.tbadk.widget.layout.ConstrainImageLayout;
import com.baidu.tbadk.widget.richText.TbRichText;
import com.baidu.tbadk.widget.richText.TbRichTextView;
import com.baidu.tieba.R;
import com.baidu.tieba.card.n;
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
/* loaded from: classes4.dex */
public class d extends com.baidu.tieba.card.a<com.baidu.tieba.homepage.topic.topicdetail.b.c> {
    private boolean Yd;
    private TextView cdZ;
    private ConstrainImageGroup eEC;
    private com.baidu.tieba.homepage.topic.topicdetail.b.c gpl;
    private ClickableHeaderImageView gpm;
    private ImageView gpn;
    private TextView gpo;
    private AgreeAloneView gpp;
    private TextView gpq;
    private ImageView gpr;
    private TbRichTextView gps;
    private RelativeLayout gpt;
    private View gpu;
    private TbImageView gpv;
    private TextView gpw;
    private View mBottomLine;
    private TbPageContext mContext;
    private int mSkinType;

    public d(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.Yd = true;
        this.mSkinType = 3;
        this.mContext = tbPageContext;
        initUI();
    }

    private void initUI() {
        View view = getView();
        this.gpm = (ClickableHeaderImageView) view.findViewById(R.id.card_topic_detail_discuss_thread_user_header);
        this.gpn = (ImageView) view.findViewById(R.id.card_topic_detail_thread_opinion_img);
        this.cdZ = (TextView) view.findViewById(R.id.card_topic_detail_discuss_thread_user_name);
        this.gpo = (TextView) view.findViewById(R.id.card_topic_detail_discuss_thread_forum_name);
        this.gps = (TbRichTextView) view.findViewById(R.id.card_topic_detail_discuss_title);
        this.gps.setClickable(true);
        this.gps.getLayoutStrategy().setLineSpacing(l.g(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds20), 1.0f);
        this.gps.setTextEllipsize(TextUtils.TruncateAt.END);
        this.gps.setMaxLines(2);
        com.baidu.tbadk.widget.richText.a aVar = new com.baidu.tbadk.widget.richText.a();
        aVar.setTextSize(l.g(getContext(), R.dimen.tbds44));
        aVar.setLineSpacing(l.g(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds7), 1.0f);
        this.gps.setLayoutStrategy(aVar);
        this.gpt = (RelativeLayout) view.findViewById(R.id.topic_detail_img_container);
        this.eEC = (ConstrainImageGroup) view.findViewById(R.id.card_topic_detail_discuss_thread_img_layout);
        this.eEC.setImageMargin(TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds10));
        com.baidu.tbadk.widget.layout.a aVar2 = new com.baidu.tbadk.widget.layout.a(3);
        aVar2.h(1.0d);
        this.eEC.setImageProcessor(aVar2);
        this.gpp = (AgreeAloneView) view.findViewById(R.id.card_topic_detail_discuss_argee_view);
        this.gpq = (TextView) view.findViewById(R.id.topic_comment_number);
        this.gpr = (ImageView) view.findViewById(R.id.topic_comment_pic);
        this.gpu = view.findViewById(R.id.card_topic_detail_discuss_original_thread_layout);
        this.gpv = (TbImageView) view.findViewById(R.id.card_topic_discuss_original_thread_pic);
        this.gpv.setRadius(l.g(getContext(), R.dimen.tbds6));
        this.gpv.setConrers(5);
        this.gpv.setDrawCorner(true);
        this.gpw = (TextView) view.findViewById(R.id.card_topic_discuss_original_thread_title);
        this.mBottomLine = view.findViewById(R.id.card_topic_detail_discuss_line_layout);
        this.cdZ.setOnClickListener(this);
        this.gpq.setOnClickListener(this);
        this.gpr.setOnClickListener(this);
        this.gps.setOnClickListener(this);
        this.gpu.setOnClickListener(this);
        this.gpw.setOnClickListener(this);
    }

    public void setConstrainLayoutPool(com.baidu.adp.lib.e.b<ConstrainImageLayout> bVar) {
        if (this.eEC != null) {
            this.eEC.setConstrainLayoutPool(bVar);
        }
    }

    public void setConstrainImagePool(com.baidu.adp.lib.e.b<TbImageView> bVar) {
        if (this.eEC != null) {
            this.eEC.setImageViewPool(bVar);
        }
    }

    @Override // com.baidu.tieba.card.a
    public void setPreloadSizeReadyCallback(com.baidu.adp.widget.a.b bVar) {
        if (this.eEC != null) {
            this.eEC.setPreloadSizeReadyCallback(bVar);
        }
    }

    @Override // com.baidu.tieba.card.a
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i && this.gpl != null) {
            this.mSkinType = i;
            this.gpm.setIsNight(this.mSkinType == 1);
            if (this.gpl.gov) {
                if (this.gpl.gou == 1) {
                    am.c(this.gpn, (int) R.drawable.label_topic_agree_red);
                    this.gpm.setBorderColor(this.mContext.getPageActivity().getResources().getColor(R.color.cp_cont_h));
                } else if (this.gpl.gou == 2) {
                    am.c(this.gpn, (int) R.drawable.label_topic_disagree_blue);
                    this.gpm.setBorderColor(this.mContext.getPageActivity().getResources().getColor(R.color.cp_link_tip_a));
                } else {
                    am.c(this.gpn, (int) R.drawable.label_topic_eat_black);
                    this.gpm.setBorderColor(this.mContext.getPageActivity().getResources().getColor(R.color.cp_cont_f));
                }
            }
            am.j(this.cdZ, R.color.cp_cont_b);
            am.j(this.gpo, R.color.cp_cont_d);
            am.j(this.gpq, R.drawable.selector_topic_detail_comment_text_color);
            if (this.gpr != null) {
                SvgManager.ajv().a(this.gpr, R.drawable.icon_pure_pb_bottom_comment_n_svg, R.color.cp_cont_j, SvgManager.SvgResourceStateType.NORMAL_PRESS);
            }
            this.gpp.onChangeSkinType(i);
            this.gps.setTextColor(am.getColor(R.color.cp_cont_b));
            am.g(this.gpu, l.g(this.mContext.getPageActivity(), R.dimen.tbds6), R.color.cp_bg_line_j, R.color.cp_bg_line_j_alpha50);
            am.j(this.gpw, R.color.cp_cont_d);
            this.eEC.onChangeSkinType();
            am.l(this.mBottomLine, R.color.cp_bg_line_e);
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
        String aD;
        int aet;
        AgreeData ags;
        if (cVar != null && cVar.threadData != null) {
            this.gpl = cVar;
            onChangeSkinType(this.mContext, TbadkCoreApplication.getInst().getSkinType());
            bh bhVar = this.gpl.threadData;
            PostData aga = bhVar.aga();
            if (aga != null) {
                if (this.gpl.source == 1) {
                    this.gpm.setData(bhVar, false, true);
                } else {
                    this.gpm.setData(bhVar, false, false);
                }
                this.gpm.setDefaultResource(R.drawable.icon_default_avatar100);
                this.gpm.setDefaultBgResource(R.color.cp_bg_line_e);
                this.gpm.setIsRound(true);
                this.gpm.setBorderWidth(2);
                this.gpm.setDrawBorder(true);
                this.gpm.setPageId(this.mContext.getUniqueId());
                if (this.gpl.gov) {
                    this.gpn.setVisibility(0);
                    if (this.gpl.gou == 1) {
                        this.gpn.setImageResource(R.drawable.label_topic_agree_red);
                        this.gpm.setBorderColor(this.mContext.getPageActivity().getResources().getColor(R.color.cp_cont_h));
                    } else if (this.gpl.gou == 2) {
                        this.gpn.setImageResource(R.drawable.label_topic_disagree_blue);
                        this.gpm.setBorderColor(this.mContext.getPageActivity().getResources().getColor(R.color.cp_link_tip_a));
                    } else {
                        this.gpn.setImageResource(R.drawable.label_topic_eat_black);
                        this.gpm.setBorderColor(this.mContext.getPageActivity().getResources().getColor(R.color.cp_cont_f));
                    }
                } else {
                    this.gpn.setVisibility(8);
                }
                if (this.gpl.source == 1) {
                    name_show = aga.aeC().getName_show();
                    aD = aq.aD(aga.getTime());
                    aet = aga.cqD();
                } else {
                    name_show = bhVar.aeC().getName_show();
                    aD = aq.aD(bhVar.getCreateTime());
                    aet = bhVar.aet();
                }
                if (!StringUtils.isNull(name_show)) {
                    this.cdZ.setText(aq.j(name_show, 14, "..."));
                }
                if (StringUtils.isNull(bhVar.aeH())) {
                    this.gpo.setText(aD);
                } else {
                    this.gpo.setText(String.format(getContext().getString(R.string.daily_topic_discuss_forum_name), aq.j(bhVar.aeH(), 10, "..."), aD));
                }
                SvgManager.ajv().a(this.gpr, R.drawable.icon_pure_pb_bottom_comment_n_svg, R.color.cp_cont_d, SvgManager.SvgResourceStateType.NORMAL_PRESS);
                String aO = aq.aO(aet);
                if (aet > 0) {
                    this.gpq.setVisibility(0);
                    this.gpq.setText(aO);
                } else {
                    this.gpq.setText(this.mContext.getString(R.string.action_comment_default));
                    this.gpq.setVisibility(0);
                }
                if (this.gpl.source == 1) {
                    ags = aga.ags();
                    ags.objType = 1;
                } else {
                    ags = bhVar.ags();
                    ags.objType = 3;
                }
                ags.threadId = bhVar.getTid();
                this.gpp.setData(ags);
                this.gpp.setTopicId(String.valueOf(this.gpl.topicId));
                if (this.gpl.source == 1) {
                    this.gps.setVisibility(0);
                    this.gps.setText(aga.cqB());
                } else {
                    this.gps.setVisibility(0);
                    int size = bhVar.aes().size();
                    if (StringUtils.isNull(bhVar.agd().toString()) && size <= 0) {
                        this.gps.setVisibility(8);
                    } else if (size > 0) {
                        TbRichText a = TbRichTextView.a(getContext(), bhVar.aes(), false);
                        if (a != null) {
                            this.gps.setText(a);
                        }
                    } else if (!StringUtils.isNull(bhVar.agd().toString())) {
                        JSONObject jSONObject = new JSONObject();
                        try {
                            jSONObject.put("type", "0");
                            jSONObject.put("text", bhVar.agd().toString());
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                        JSONArray jSONArray = new JSONArray();
                        jSONArray.put(jSONObject);
                        this.gps.setText(TbRichTextView.a(getContext(), jSONArray, false));
                    } else {
                        this.gps.setVisibility(8);
                    }
                }
                if (this.gpl.source == 1) {
                    this.gpu.setVisibility(0);
                    this.gpt.setVisibility(8);
                    ArrayList<MediaData> aeM = bhVar.aeM();
                    String str = null;
                    String title = bhVar.getTitle();
                    if (v.Z(aeM) != 0 && !v.aa(cVar.threadData.aeM())) {
                        Iterator<MediaData> it = cVar.threadData.aeM().iterator();
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
                    if (StringUtils.isNull(title)) {
                        this.gpu.setVisibility(8);
                    } else {
                        this.gpu.setVisibility(0);
                        this.gpw.setText(title);
                        if (StringUtils.isNull(str)) {
                            am.c(this.gpv, (int) R.drawable.pic_frs_topic_shareinone);
                        } else {
                            this.gpv.startLoad(str, 10, false);
                        }
                    }
                } else {
                    this.gpu.setVisibility(8);
                    this.gpt.setVisibility(0);
                    b(cVar);
                }
                setPageUniqueId(getTag());
            }
        }
    }

    private void b(com.baidu.tieba.homepage.topic.topicdetail.b.c cVar) {
        final bh bhVar = cVar.threadData;
        ArrayList<MediaData> aeM = bhVar.aeM();
        if (i.ace().aci() && v.Z(aeM) != 0) {
            final LinkedList linkedList = new LinkedList();
            for (int i = 0; i < aeM.size(); i++) {
                MediaData mediaData = (MediaData) v.c(aeM, i);
                if (mediaData != null && mediaData.getType() == 3) {
                    linkedList.add(mediaData);
                }
            }
            if (v.Z(linkedList) > 0) {
                this.gpt.setVisibility(0);
                this.eEC.setFromCDN(this.Yd);
                this.eEC.setImageClickListener(new com.baidu.tbadk.widget.layout.d() { // from class: com.baidu.tieba.homepage.topic.topicdetail.view.d.1
                    @Override // com.baidu.tbadk.widget.layout.d
                    public void a(View view, int i2, boolean z) {
                        if (!z) {
                            d.this.a(view, linkedList, i2, bhVar);
                        } else {
                            d.this.aqp();
                        }
                    }
                });
                this.eEC.setImageMediaList(linkedList);
                return;
            }
            this.gpt.setVisibility(8);
            return;
        }
        this.gpt.setVisibility(8);
    }

    private void setPageUniqueId(BdUniqueId bdUniqueId) {
        setTag(bdUniqueId);
        if (this.eEC != null) {
            this.eEC.setPageUniqueId(bdUniqueId);
        }
    }

    public void aqp() {
        if (this.gpl != null && this.gpl.threadData != null) {
            PbActivityConfig addLocateParam = new PbActivityConfig(this.mContext.getPageActivity()).createFromThreadCfg(this.gpl.threadData, null, IXAdSystemUtils.NT_NONE, 18003, true, false, false).addLocateParam(null);
            addLocateParam.setForumId(String.valueOf(this.gpl.threadData.getFid()));
            addLocateParam.setFrom(PbActivityConfig.KEY_FROM_PERSONALIZE);
            addLocateParam.setForumName(this.gpl.threadData.aeH());
            addLocateParam.setStartFrom(this.currentPageType);
            addLocateParam.setJumpGodReply(false);
            n.vW(this.gpl.threadData.getTid());
            this.mTbPageContext.sendMessage(new CustomMessage(2004001, addLocateParam));
        }
    }

    private void byy() {
        PbActivityConfig createNormalCfg = new PbActivityConfig(this.mContext.getPageActivity()).createNormalCfg(String.valueOf(this.gpl.threadData.getTid()), String.format("%1$s", this.gpl.threadData.aga().getId()) + "", 1, "mention");
        createNormalCfg.setStartFrom(12);
        MessageManager.getInstance().sendMessage(new CustomMessage(2004001, createNormalCfg));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(View view, List<MediaData> list, int i, bh bhVar) {
        if (!TbadkCoreApplication.getInst().appResponseToCmd(2010000)) {
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
                    imageUrlData.urlType = this.Yd ? 13 : 14;
                    imageUrlData.imageUrl = mediaData.getPicUrl();
                    imageUrlData.originalUrl = mediaData.getOriginalUrl();
                    imageUrlData.originalSize = mediaData.getOriginalSize();
                    imageUrlData.isLongPic = mediaData.isLongPic();
                    imageUrlData.mIsShowOrigonButton = mediaData.isShowOriginBtn();
                    imageUrlData.threadId = com.baidu.adp.lib.g.b.e(bhVar.getTid(), -1L);
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
        ImageViewerConfig createConfig = new ImageViewerConfig(this.mTbPageContext.getPageActivity()).createConfig(arrayList, i, bhVar.aeH(), String.valueOf(bhVar.getFid()), bhVar.getTid(), this.Yd, arrayList.size() > 0 ? arrayList.get(0) : "", true, concurrentHashMap, true);
        if (this.currentPageType == 2) {
            createConfig.getIntent().putExtra("from", "index");
        } else {
            createConfig.getIntent().putExtra("from", ImageViewerConfig.FROM_OTHER);
        }
        Rect rect = new Rect();
        view.getGlobalVisibleRect(rect);
        createConfig.setSrcRectInScreen(rect, UtilHelper.fixedDrawableRect(rect, view));
        MessageManager.getInstance().sendMessage(new CustomMessage(2010000, createConfig));
        HistoryMessage historyMessage = new HistoryMessage();
        historyMessage.Activity = this.mTbPageContext;
        historyMessage.threadId = bhVar.getId();
        historyMessage.threadName = bhVar.getTitle();
        historyMessage.forumName = bhVar.aeH();
        historyMessage.postID = bhVar.aeS();
        MessageManager.getInstance().dispatchResponsedMessage(historyMessage);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.gpl != null && this.gpl.threadData != null) {
            if (view == this.gps) {
                if (this.gpl.source == 1) {
                    byy();
                } else {
                    aqp();
                }
                yJ("1");
            }
            if (view == this.gpq || view == this.gpr) {
                if (this.gpl.source == 1) {
                    byy();
                } else {
                    aqp();
                }
                yJ("3");
            } else if (view == this.cdZ) {
                byz();
            } else {
                aqp();
                yJ("2");
            }
        }
    }

    private void byz() {
        MetaData aeC;
        if (this.gpl != null && this.gpl.threadData != null) {
            bh bhVar = this.gpl.threadData;
            if (this.gpl.source == 1 && bhVar.aga() != null) {
                aeC = bhVar.aga().aeC();
            } else {
                aeC = bhVar.aeC();
            }
            if (aeC != null && !StringUtils.isNull(aeC.getName_show()) && !StringUtils.isNull(aeC.getUserId())) {
                long e = com.baidu.adp.lib.g.b.e(aeC.getUserId(), 0L);
                boolean z = e == com.baidu.adp.lib.g.b.e(TbadkCoreApplication.getCurrentAccount(), 0L);
                if (bhVar.afM() != null && bhVar.afM().channelId > 0) {
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new ChannelHomeActivityConfig(getContext(), bhVar.afM().channelId, bhVar.afM().mCurrentPage)));
                    return;
                }
                PersonPolymericActivityConfig createNormalConfig = new PersonPolymericActivityConfig(getContext()).createNormalConfig(e, z, aeC.isBigV());
                createNormalConfig.setSourceTid(bhVar.getTid());
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, createNormalConfig));
            }
        }
    }

    private void yJ(String str) {
        TiebaStatic.log(new an("c13356").bT("obj_locate", str).bT("tid", this.gpl.threadData.getTid()).n("topic_id", this.gpl.topicId).bT("obj_type", String.valueOf(this.gpl.source)));
    }
}
