package com.baidu.tieba.chosen.posts.a;

import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.atomData.FrsActivityConfig;
import com.baidu.tbadk.core.i;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.mvc.core.ViewEventCenter;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import tbclient.HotThread.tinfo;
/* loaded from: classes8.dex */
public class c extends com.baidu.tbadk.mvc.f.a<tinfo, com.baidu.tbadk.mvc.d.b> {
    private View.OnClickListener arL;
    private TextView cGN;
    private TextView fMh;
    private TextView fMi;
    private TextView fMm;
    private RelativeLayout fMq;
    private TbImageView fMr;
    private TbImageView fMs;
    private TbImageView fMt;

    public c(TbPageContext<?> tbPageContext, View view, ViewEventCenter viewEventCenter) {
        super(tbPageContext, view, viewEventCenter);
        this.arL = new View.OnClickListener() { // from class: com.baidu.tieba.chosen.posts.a.c.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                Object tag = view2.getTag();
                if (tag instanceof Integer) {
                    com.baidu.tbadk.mvc.c.b bVar = new com.baidu.tbadk.mvc.c.b(4096, new d(((Integer) tag).intValue(), c.this.getData()), null, null);
                    bVar.setUniqueId(c.this.getUniqueId());
                    c.this.aOy().dispatchMvcEvent(bVar);
                }
            }
        };
        this.cGN = (TextView) view.findViewById(R.id.chosen_picture_title);
        this.fMh = (TextView) view.findViewById(R.id.chosen_picture_praise);
        this.fMi = (TextView) view.findViewById(R.id.chosen_picture_comment);
        this.fMm = (TextView) view.findViewById(R.id.chosen_picture_head);
        this.fMq = (RelativeLayout) view.findViewById(R.id.chosen_picture_pic_container);
        this.fMr = (TbImageView) view.findViewById(R.id.chosen_picture_pic_one);
        this.fMs = (TbImageView) view.findViewById(R.id.chosen_picture_pic_two);
        this.fMt = (TbImageView) view.findViewById(R.id.chosen_picture_pic_thr);
        this.fMr.setOnClickListener(this.arL);
        this.fMs.setOnClickListener(this.arL);
        this.fMt.setOnClickListener(this.arL);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.mvc.f.e
    /* renamed from: a */
    public void ag(final tinfo tinfoVar) {
        super.ag(tinfoVar);
        if (tinfoVar != null) {
            if (StringUtils.isNull(tinfoVar.forum_name)) {
                this.cGN.setVisibility(8);
            } else {
                this.cGN.setVisibility(0);
                this.cGN.setText(UtilHelper.getFixedText(getContext().getString(R.string.chosen_pb_original_bar, tinfoVar.forum_name), 7, false));
                this.cGN.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.chosen.posts.a.c.2
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        String str = tinfoVar.forum_name;
                        if (aq.isForumName(str)) {
                            TiebaStatic.eventStat(c.this.getActivity(), "kantie_6", null, 1, new Object[0]);
                            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, new FrsActivityConfig(c.this.getActivity()).createNormalCfg(str, FrsActivityConfig.FRS_FROM_RECOMMEND)));
                        }
                    }
                });
            }
            if (StringUtils.isNull(tinfoVar.title)) {
                this.fMm.setVisibility(8);
            } else {
                this.fMm.setVisibility(0);
                this.fMm.setText(tinfoVar.title);
            }
            if (tinfoVar.zan_num == null) {
                this.fMh.setVisibility(8);
            } else {
                this.fMh.setVisibility(0);
                this.fMh.setText(tinfoVar.zan_num + "");
            }
            if (tinfoVar.reply_num == null) {
                this.fMi.setVisibility(8);
            } else {
                this.fMi.setVisibility(0);
                this.fMi.setText(tinfoVar.reply_num + "");
            }
            b(tinfoVar);
        }
    }

    private void b(tinfo tinfoVar) {
        if (tinfoVar != null) {
            if (i.axy().isShowImages() && tinfoVar.pics != null && tinfoVar.pics.size() > 0) {
                this.fMq.setVisibility(0);
                switch (tinfoVar.pics.size()) {
                    case 0:
                    default:
                        return;
                    case 1:
                        break;
                    case 3:
                        String str = tinfoVar.pics.get(2).small_pic;
                        this.fMt.setVisibility(0);
                        this.fMt.startLoad(str, 10, false);
                        this.fMt.setTag(2);
                    case 2:
                        String str2 = tinfoVar.pics.get(1).small_pic;
                        this.fMs.setVisibility(0);
                        this.fMs.startLoad(str2, 10, false);
                        this.fMs.setTag(1);
                        break;
                }
                String str3 = tinfoVar.pics.get(0).small_pic;
                this.fMr.setVisibility(0);
                this.fMr.startLoad(str3, 10, false);
                this.fMr.setTag(0);
                return;
            }
            this.fMq.setVisibility(8);
        }
    }

    @Override // com.baidu.tieba.tbadkCore.q
    public boolean b(TbPageContext<?> tbPageContext, int i) {
        com.baidu.tbadk.core.c layoutMode = getPageContext().getLayoutMode();
        layoutMode.setNightMode(i == 1);
        layoutMode.onModeChanged(getRootView());
        return true;
    }
}
