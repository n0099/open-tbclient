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
import com.baidu.live.tbadk.core.data.RequestResponseCode;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.live.tbadk.core.util.StringHelper;
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
    private boolean Hx;
    private TbPageContext ceu;
    private TextView crw;
    private ConstrainImageGroup eMr;
    private com.baidu.tieba.homepage.topic.topicdetail.b.c gnT;
    private ClickableHeaderImageView gnU;
    private ImageView gnV;
    private TextView gnW;
    private AgreeAloneView gnX;
    private TextView gnY;
    private ImageView gnZ;
    private TbRichTextView goa;
    private RelativeLayout gob;
    private View goc;
    private TbImageView god;
    private TextView goe;
    private View mBottomLine;
    private int mSkinType;

    public d(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.Hx = true;
        this.mSkinType = 3;
        this.ceu = tbPageContext;
        initUI();
    }

    private void initUI() {
        View view = getView();
        this.gnU = (ClickableHeaderImageView) view.findViewById(R.id.card_topic_detail_discuss_thread_user_header);
        this.gnV = (ImageView) view.findViewById(R.id.card_topic_detail_thread_opinion_img);
        this.crw = (TextView) view.findViewById(R.id.card_topic_detail_discuss_thread_user_name);
        this.gnW = (TextView) view.findViewById(R.id.card_topic_detail_discuss_thread_forum_name);
        this.goa = (TbRichTextView) view.findViewById(R.id.card_topic_detail_discuss_title);
        this.goa.setClickable(true);
        this.goa.getLayoutStrategy().setLineSpacing(l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds20), 1.0f);
        this.goa.setTextEllipsize(TextUtils.TruncateAt.END);
        this.goa.setMaxLines(2);
        com.baidu.tbadk.widget.richText.a aVar = new com.baidu.tbadk.widget.richText.a();
        aVar.setTextSize(l.getDimens(getContext(), R.dimen.tbds44));
        aVar.setLineSpacing(l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds7), 1.0f);
        this.goa.setLayoutStrategy(aVar);
        this.gob = (RelativeLayout) view.findViewById(R.id.topic_detail_img_container);
        this.eMr = (ConstrainImageGroup) view.findViewById(R.id.card_topic_detail_discuss_thread_img_layout);
        this.eMr.setImageMargin(TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds10));
        com.baidu.tbadk.widget.layout.a aVar2 = new com.baidu.tbadk.widget.layout.a(3);
        aVar2.g(1.0d);
        this.eMr.setImageProcessor(aVar2);
        this.gnX = (AgreeAloneView) view.findViewById(R.id.card_topic_detail_discuss_argee_view);
        this.gnY = (TextView) view.findViewById(R.id.topic_comment_number);
        this.gnZ = (ImageView) view.findViewById(R.id.topic_comment_pic);
        this.goc = view.findViewById(R.id.card_topic_detail_discuss_original_thread_layout);
        this.god = (TbImageView) view.findViewById(R.id.card_topic_discuss_original_thread_pic);
        this.god.setRadius(l.getDimens(getContext(), R.dimen.tbds6));
        this.god.setConrers(5);
        this.god.setDrawCorner(true);
        this.goe = (TextView) view.findViewById(R.id.card_topic_discuss_original_thread_title);
        this.mBottomLine = view.findViewById(R.id.card_topic_detail_discuss_line_layout);
        this.crw.setOnClickListener(this);
        this.gnY.setOnClickListener(this);
        this.gnZ.setOnClickListener(this);
        this.goa.setOnClickListener(this);
        this.goc.setOnClickListener(this);
        this.goe.setOnClickListener(this);
    }

    public void setConstrainLayoutPool(com.baidu.adp.lib.e.b<ConstrainImageLayout> bVar) {
        if (this.eMr != null) {
            this.eMr.setConstrainLayoutPool(bVar);
        }
    }

    public void setConstrainImagePool(com.baidu.adp.lib.e.b<TbImageView> bVar) {
        if (this.eMr != null) {
            this.eMr.setImageViewPool(bVar);
        }
    }

    @Override // com.baidu.tieba.card.a
    public void setPreloadSizeReadyCallback(com.baidu.adp.widget.a.b bVar) {
        if (this.eMr != null) {
            this.eMr.setPreloadSizeReadyCallback(bVar);
        }
    }

    @Override // com.baidu.tieba.card.a
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i && this.gnT != null) {
            this.mSkinType = i;
            this.gnU.setIsNight(this.mSkinType == 1);
            if (this.gnT.gnd) {
                if (this.gnT.gnc == 1) {
                    am.setImageResource(this.gnV, R.drawable.label_topic_agree_red);
                    this.gnU.setBorderColor(this.ceu.getPageActivity().getResources().getColor(R.color.cp_cont_h));
                } else if (this.gnT.gnc == 2) {
                    am.setImageResource(this.gnV, R.drawable.label_topic_disagree_blue);
                    this.gnU.setBorderColor(this.ceu.getPageActivity().getResources().getColor(R.color.cp_link_tip_a));
                } else {
                    am.setImageResource(this.gnV, R.drawable.label_topic_eat_black);
                    this.gnU.setBorderColor(this.ceu.getPageActivity().getResources().getColor(R.color.cp_cont_f));
                }
            }
            am.setViewTextColor(this.crw, (int) R.color.cp_cont_b);
            am.setViewTextColor(this.gnW, (int) R.color.cp_cont_d);
            am.setViewTextColor(this.gnY, (int) R.drawable.selector_topic_detail_comment_text_color);
            if (this.gnZ != null) {
                SvgManager.amL().a(this.gnZ, R.drawable.icon_pure_pb_bottom_comment_n_svg, R.color.cp_cont_j, SvgManager.SvgResourceStateType.NORMAL_PRESS);
            }
            this.gnX.onChangeSkinType(i);
            this.goa.setTextColor(am.getColor(R.color.cp_cont_b));
            am.e(this.goc, l.getDimens(this.ceu.getPageActivity(), R.dimen.tbds6), R.color.cp_bg_line_j, R.color.cp_bg_line_j_alpha50);
            am.setViewTextColor(this.goe, (int) R.color.cp_cont_d);
            this.eMr.onChangeSkinType();
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
        int aiv;
        AgreeData akt;
        if (cVar != null && cVar.caz != null) {
            this.gnT = cVar;
            onChangeSkinType(this.ceu, TbadkCoreApplication.getInst().getSkinType());
            bh bhVar = this.gnT.caz;
            PostData akb = bhVar.akb();
            if (akb != null) {
                if (this.gnT.source == 1) {
                    this.gnU.setData(bhVar, false, true);
                } else {
                    this.gnU.setData(bhVar, false, false);
                }
                this.gnU.setDefaultResource(R.drawable.icon_default_avatar100);
                this.gnU.setDefaultBgResource(R.color.cp_bg_line_e);
                this.gnU.setIsRound(true);
                this.gnU.setBorderWidth(2);
                this.gnU.setDrawBorder(true);
                this.gnU.setPageId(this.ceu.getUniqueId());
                if (this.gnT.gnd) {
                    this.gnV.setVisibility(0);
                    if (this.gnT.gnc == 1) {
                        this.gnV.setImageResource(R.drawable.label_topic_agree_red);
                        this.gnU.setBorderColor(this.ceu.getPageActivity().getResources().getColor(R.color.cp_cont_h));
                    } else if (this.gnT.gnc == 2) {
                        this.gnV.setImageResource(R.drawable.label_topic_disagree_blue);
                        this.gnU.setBorderColor(this.ceu.getPageActivity().getResources().getColor(R.color.cp_link_tip_a));
                    } else {
                        this.gnV.setImageResource(R.drawable.label_topic_eat_black);
                        this.gnU.setBorderColor(this.ceu.getPageActivity().getResources().getColor(R.color.cp_cont_f));
                    }
                } else {
                    this.gnV.setVisibility(8);
                }
                if (this.gnT.source == 1) {
                    name_show = akb.aiE().getName_show();
                    formatTime = aq.getFormatTime(akb.getTime());
                    aiv = akb.cor();
                } else {
                    name_show = bhVar.aiE().getName_show();
                    formatTime = aq.getFormatTime(bhVar.getCreateTime());
                    aiv = bhVar.aiv();
                }
                if (!StringUtils.isNull(name_show)) {
                    this.crw.setText(aq.cutChineseAndEnglishWithSuffix(name_show, 14, StringHelper.STRING_MORE));
                }
                if (StringUtils.isNull(bhVar.aiJ())) {
                    this.gnW.setText(formatTime);
                } else {
                    this.gnW.setText(String.format(getContext().getString(R.string.daily_topic_discuss_forum_name), aq.cutChineseAndEnglishWithSuffix(bhVar.aiJ(), 10, StringHelper.STRING_MORE), formatTime));
                }
                SvgManager.amL().a(this.gnZ, R.drawable.icon_pure_pb_bottom_comment_n_svg, R.color.cp_cont_d, SvgManager.SvgResourceStateType.NORMAL_PRESS);
                String numFormatOverWan = aq.numFormatOverWan(aiv);
                if (aiv > 0) {
                    this.gnY.setVisibility(0);
                    this.gnY.setText(numFormatOverWan);
                } else {
                    this.gnY.setText(this.ceu.getString(R.string.action_comment_default));
                    this.gnY.setVisibility(0);
                }
                if (this.gnT.source == 1) {
                    akt = akb.akt();
                    akt.objType = 1;
                } else {
                    akt = bhVar.akt();
                    akt.objType = 3;
                }
                akt.threadId = bhVar.getTid();
                this.gnX.setData(akt);
                this.gnX.setTopicId(String.valueOf(this.gnT.topicId));
                if (this.gnT.source == 1) {
                    this.goa.setVisibility(0);
                    this.goa.setText(akb.cop());
                } else {
                    this.goa.setVisibility(0);
                    int size = bhVar.aiu().size();
                    if (StringUtils.isNull(bhVar.ake().toString()) && size <= 0) {
                        this.goa.setVisibility(8);
                    } else if (size > 0) {
                        TbRichText a = TbRichTextView.a(getContext(), bhVar.aiu(), false);
                        if (a != null) {
                            this.goa.setText(a);
                        }
                    } else if (!StringUtils.isNull(bhVar.ake().toString())) {
                        JSONObject jSONObject = new JSONObject();
                        try {
                            jSONObject.put("type", "0");
                            jSONObject.put("text", bhVar.ake().toString());
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                        JSONArray jSONArray = new JSONArray();
                        jSONArray.put(jSONObject);
                        this.goa.setText(TbRichTextView.a(getContext(), jSONArray, false));
                    } else {
                        this.goa.setVisibility(8);
                    }
                }
                if (this.gnT.source == 1) {
                    this.goc.setVisibility(0);
                    this.gob.setVisibility(8);
                    ArrayList<MediaData> aiO = bhVar.aiO();
                    String str = null;
                    String title = bhVar.getTitle();
                    if (v.getCount(aiO) != 0 && !v.isEmpty(cVar.caz.aiO())) {
                        Iterator<MediaData> it = cVar.caz.aiO().iterator();
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
                        this.goc.setVisibility(8);
                    } else {
                        this.goc.setVisibility(0);
                        this.goe.setText(title);
                        if (StringUtils.isNull(str)) {
                            am.setImageResource(this.god, R.drawable.pic_frs_topic_shareinone);
                        } else {
                            this.god.startLoad(str, 10, false);
                        }
                    }
                } else {
                    this.goc.setVisibility(8);
                    this.gob.setVisibility(0);
                    b(cVar);
                }
                setPageUniqueId(getTag());
            }
        }
    }

    private void b(com.baidu.tieba.homepage.topic.topicdetail.b.c cVar) {
        final bh bhVar = cVar.caz;
        ArrayList<MediaData> aiO = bhVar.aiO();
        if (i.ago().isShowImages() && v.getCount(aiO) != 0) {
            final LinkedList linkedList = new LinkedList();
            for (int i = 0; i < aiO.size(); i++) {
                MediaData mediaData = (MediaData) v.getItem(aiO, i);
                if (mediaData != null && mediaData.getType() == 3) {
                    linkedList.add(mediaData);
                }
            }
            if (v.getCount(linkedList) > 0) {
                this.gob.setVisibility(0);
                this.eMr.setFromCDN(this.Hx);
                this.eMr.setImageClickListener(new com.baidu.tbadk.widget.layout.d() { // from class: com.baidu.tieba.homepage.topic.topicdetail.view.d.1
                    @Override // com.baidu.tbadk.widget.layout.d
                    public void b(View view, int i2, boolean z) {
                        if (!z) {
                            d.this.a(view, linkedList, i2, bhVar);
                        } else {
                            d.this.ash();
                        }
                    }
                });
                this.eMr.setImageMediaList(linkedList);
                return;
            }
            this.gob.setVisibility(8);
            return;
        }
        this.gob.setVisibility(8);
    }

    private void setPageUniqueId(BdUniqueId bdUniqueId) {
        setTag(bdUniqueId);
        if (this.eMr != null) {
            this.eMr.setPageUniqueId(bdUniqueId);
        }
    }

    public void ash() {
        if (this.gnT != null && this.gnT.caz != null) {
            PbActivityConfig addLocateParam = new PbActivityConfig(this.ceu.getPageActivity()).createFromThreadCfg(this.gnT.caz, null, IXAdSystemUtils.NT_NONE, RequestResponseCode.REQUEST_FRS_TO_PB, true, false, false).addLocateParam(null);
            addLocateParam.setForumId(String.valueOf(this.gnT.caz.getFid()));
            addLocateParam.setFrom(PbActivityConfig.KEY_FROM_PERSONALIZE);
            addLocateParam.setForumName(this.gnT.caz.aiJ());
            addLocateParam.setStartFrom(this.currentPageType);
            addLocateParam.setJumpGodReply(false);
            n.uz(this.gnT.caz.getTid());
            this.mTbPageContext.sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, addLocateParam));
        }
    }

    private void bvA() {
        PbActivityConfig createNormalCfg = new PbActivityConfig(this.ceu.getPageActivity()).createNormalCfg(String.valueOf(this.gnT.caz.getTid()), String.format("%1$s", this.gnT.caz.akb().getId()) + "", 1, "mention");
        createNormalCfg.setStartFrom(12);
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, createNormalCfg));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(View view, List<MediaData> list, int i, bh bhVar) {
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
                    imageUrlData.urlType = this.Hx ? 13 : 14;
                    imageUrlData.imageUrl = mediaData.getPicUrl();
                    imageUrlData.originalUrl = mediaData.getOriginalUrl();
                    imageUrlData.originalSize = mediaData.getOriginalSize();
                    imageUrlData.isLongPic = mediaData.isLongPic();
                    imageUrlData.mIsShowOrigonButton = mediaData.isShowOriginBtn();
                    imageUrlData.threadId = com.baidu.adp.lib.g.b.toLong(bhVar.getTid(), -1L);
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
        ImageViewerConfig createConfig = new ImageViewerConfig(this.mTbPageContext.getPageActivity()).createConfig(arrayList, i, bhVar.aiJ(), String.valueOf(bhVar.getFid()), bhVar.getTid(), this.Hx, arrayList.size() > 0 ? arrayList.get(0) : "", true, concurrentHashMap, true);
        if (this.currentPageType == 2) {
            createConfig.getIntent().putExtra("from", "index");
        } else {
            createConfig.getIntent().putExtra("from", "other");
        }
        Rect rect = new Rect();
        view.getGlobalVisibleRect(rect);
        createConfig.setSrcRectInScreen(rect, UtilHelper.fixedDrawableRect(rect, view));
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.IMAGE_VIEWER_CUSTOM_CMD, createConfig));
        HistoryMessage historyMessage = new HistoryMessage();
        historyMessage.Activity = this.mTbPageContext;
        historyMessage.threadId = bhVar.getId();
        historyMessage.threadName = bhVar.getTitle();
        historyMessage.forumName = bhVar.aiJ();
        historyMessage.postID = bhVar.aiU();
        MessageManager.getInstance().dispatchResponsedMessage(historyMessage);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.gnT != null && this.gnT.caz != null) {
            if (view == this.goa) {
                if (this.gnT.source == 1) {
                    bvA();
                } else {
                    ash();
                }
                xc("1");
            }
            if (view == this.gnY || view == this.gnZ) {
                if (this.gnT.source == 1) {
                    bvA();
                } else {
                    ash();
                }
                xc("3");
            } else if (view == this.crw) {
                bvB();
            } else {
                ash();
                xc("2");
            }
        }
    }

    private void bvB() {
        MetaData aiE;
        if (this.gnT != null && this.gnT.caz != null) {
            bh bhVar = this.gnT.caz;
            if (this.gnT.source == 1 && bhVar.akb() != null) {
                aiE = bhVar.akb().aiE();
            } else {
                aiE = bhVar.aiE();
            }
            if (aiE != null && !StringUtils.isNull(aiE.getName_show()) && !StringUtils.isNull(aiE.getUserId())) {
                long j = com.baidu.adp.lib.g.b.toLong(aiE.getUserId(), 0L);
                boolean z = j == com.baidu.adp.lib.g.b.toLong(TbadkCoreApplication.getCurrentAccount(), 0L);
                if (bhVar.ajN() != null && bhVar.ajN().channelId > 0) {
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new ChannelHomeActivityConfig(getContext(), bhVar.ajN().channelId, bhVar.ajN().Zv)));
                    return;
                }
                PersonPolymericActivityConfig createNormalConfig = new PersonPolymericActivityConfig(getContext()).createNormalConfig(j, z, aiE.isBigV());
                createNormalConfig.setSourceTid(bhVar.getTid());
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, createNormalConfig));
            }
        }
    }

    private void xc(String str) {
        TiebaStatic.log(new an("c13356").bS("obj_locate", str).bS("tid", this.gnT.caz.getTid()).p("topic_id", this.gnT.topicId).bS("obj_type", String.valueOf(this.gnT.source)));
    }
}
