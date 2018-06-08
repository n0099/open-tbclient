package com.baidu.tieba.frs.worldcup.videotopic.insertcard;

import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.VideoTopicActivityConfig;
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tieba.d;
import com.baidu.tieba.frs.worldcup.talkball.b.f;
/* loaded from: classes2.dex */
public class a extends com.baidu.tieba.card.a<f> {
    private TextView awK;
    private View biz;
    private RecyclerView cUl;
    private ForbidParentSwipeBackLinearLayout dGM;
    private LinearLayout dGN;
    private TextView dGO;
    private ImageView dGP;
    private c dGQ;
    private f dGR;
    private String mForumId;

    public a(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext);
        setTag(bdUniqueId);
        this.currentPageType = 3;
        this.mTbPageContext = tbPageContext;
        View view = getView();
        this.dGM = (ForbidParentSwipeBackLinearLayout) view.findViewById(d.g.video_topic_root);
        this.cUl = (RecyclerView) view.findViewById(d.g.list);
        this.dGO = (TextView) view.findViewById(d.g.video_topic);
        this.dGN = (LinearLayout) view.findViewById(d.g.top_view);
        this.awK = (TextView) view.findViewById(d.g.more);
        this.biz = view.findViewById(d.g.divider_line);
        this.dGP = (ImageView) view.findViewById(d.g.image_go);
        this.dGQ = new c(this.mTbPageContext);
        this.cUl.setAdapter(this.dGQ);
        this.cUl.setLayoutManager(new LinearLayoutManager(this.mTbPageContext.getPageActivity(), 0, false));
        this.cUl.setItemAnimator(new DefaultItemAnimator());
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.a
    public void a(f fVar) {
        if (fVar != null) {
            this.dGR = fVar;
            if (ao.isEmpty(fVar.getTopicName())) {
                this.dGO.setText(d.k.frs_video_topic);
            } else {
                this.dGO.setText(fVar.getTopicName());
                this.dGQ.setTopicName(fVar.getTopicName());
            }
            if (fVar.aAu() != null) {
                this.dGQ.setData(fVar.aAu());
                this.dGQ.notifyDataSetChanged();
            }
            this.dGM.setOnClickListener(this);
            d(this.mTbPageContext, TbadkCoreApplication.getInst().getSkinType());
        }
    }

    @Override // com.baidu.tieba.card.a
    public void d(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            al.i(this.dGM, d.f.addresslist_item_bg);
            al.i(this.dGN, d.f.addresslist_item_bg);
            al.i(this.dGP, d.f.icon_arrow12_gray60_right);
            al.h(this.dGO, d.C0141d.cp_cont_f);
            al.h(this.awK, d.C0141d.cp_cont_f);
            al.j(this.biz, d.C0141d.cp_bg_line_e);
        }
        this.mSkinType = i;
    }

    @Override // com.baidu.tieba.card.a
    public int getLayout() {
        return d.i.card_insert_video_topic_layout;
    }

    public void setForumId(String str) {
        this.mForumId = str;
        this.dGQ.setForumId(str);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.dGR != null) {
            MessageManager.getInstance().sendMessage(new CustomMessage(2003021, new VideoTopicActivityConfig(this.mContext).createNormalCfg(this.dGR.aAt().intValue(), this.dGR.getTopicName(), this.mForumId)));
        }
    }
}
