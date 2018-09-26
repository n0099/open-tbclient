package com.baidu.tieba.chosen.posts.a;

import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.atomData.FrsActivityConfig;
import com.baidu.tbadk.core.i;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.mvc.core.ViewEventCenter;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.e;
import tbclient.HotThread.tinfo;
/* loaded from: classes3.dex */
public class c extends com.baidu.tbadk.mvc.f.a<tinfo, com.baidu.tbadk.mvc.d.b> {
    private TextView adB;
    private TextView cML;
    private TextView cMM;
    private TextView cMQ;
    private RelativeLayout cMU;
    private TbImageView cMV;
    private TbImageView cMW;
    private TbImageView cMX;
    private View.OnClickListener cgg;

    public c(TbPageContext<?> tbPageContext, View view, ViewEventCenter viewEventCenter) {
        super(tbPageContext, view, viewEventCenter);
        this.cgg = new View.OnClickListener() { // from class: com.baidu.tieba.chosen.posts.a.c.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                Object tag = view2.getTag();
                if (tag instanceof Integer) {
                    com.baidu.tbadk.mvc.c.b bVar = new com.baidu.tbadk.mvc.c.b(4096, new d(((Integer) tag).intValue(), c.this.getData()), null, null);
                    bVar.setUniqueId(c.this.getUniqueId());
                    c.this.LA().dispatchMvcEvent(bVar);
                }
            }
        };
        this.adB = (TextView) view.findViewById(e.g.chosen_picture_title);
        this.cML = (TextView) view.findViewById(e.g.chosen_picture_praise);
        this.cMM = (TextView) view.findViewById(e.g.chosen_picture_comment);
        this.cMQ = (TextView) view.findViewById(e.g.chosen_picture_head);
        this.cMU = (RelativeLayout) view.findViewById(e.g.chosen_picture_pic_container);
        this.cMV = (TbImageView) view.findViewById(e.g.chosen_picture_pic_one);
        this.cMW = (TbImageView) view.findViewById(e.g.chosen_picture_pic_two);
        this.cMX = (TbImageView) view.findViewById(e.g.chosen_picture_pic_thr);
        this.cMV.setOnClickListener(this.cgg);
        this.cMW.setOnClickListener(this.cgg);
        this.cMX.setOnClickListener(this.cgg);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.mvc.f.e
    /* renamed from: a */
    public void H(final tinfo tinfoVar) {
        super.H(tinfoVar);
        if (tinfoVar != null) {
            if (StringUtils.isNull(tinfoVar.forum_name)) {
                this.adB.setVisibility(8);
            } else {
                this.adB.setVisibility(0);
                this.adB.setText(UtilHelper.getFixedText(getContext().getString(e.j.chosen_pb_original_bar, tinfoVar.forum_name), 7, false));
                this.adB.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.chosen.posts.a.c.2
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        String str = tinfoVar.forum_name;
                        if (ao.bw(str)) {
                            TiebaStatic.eventStat(c.this.getActivity(), "kantie_6", null, 1, new Object[0]);
                            MessageManager.getInstance().sendMessage(new CustomMessage(2003000, new FrsActivityConfig(c.this.getActivity()).createNormalCfg(str, FrsActivityConfig.FRS_FROM_RECOMMEND)));
                        }
                    }
                });
            }
            if (StringUtils.isNull(tinfoVar.title)) {
                this.cMQ.setVisibility(8);
            } else {
                this.cMQ.setVisibility(0);
                this.cMQ.setText(tinfoVar.title);
            }
            if (tinfoVar.zan_num == null) {
                this.cML.setVisibility(8);
            } else {
                this.cML.setVisibility(0);
                this.cML.setText(tinfoVar.zan_num + "");
            }
            if (tinfoVar.reply_num == null) {
                this.cMM.setVisibility(8);
            } else {
                this.cMM.setVisibility(0);
                this.cMM.setText(tinfoVar.reply_num + "");
            }
            b(tinfoVar);
        }
    }

    private void b(tinfo tinfoVar) {
        if (tinfoVar != null) {
            if (i.uj().un() && tinfoVar.pics != null && tinfoVar.pics.size() > 0) {
                this.cMU.setVisibility(0);
                switch (tinfoVar.pics.size()) {
                    case 0:
                    default:
                        return;
                    case 1:
                        break;
                    case 3:
                        String str = tinfoVar.pics.get(2).small_pic;
                        this.cMX.setVisibility(0);
                        this.cMX.startLoad(str, 10, false);
                        this.cMX.setTag(2);
                    case 2:
                        String str2 = tinfoVar.pics.get(1).small_pic;
                        this.cMW.setVisibility(0);
                        this.cMW.startLoad(str2, 10, false);
                        this.cMW.setTag(1);
                        break;
                }
                String str3 = tinfoVar.pics.get(0).small_pic;
                this.cMV.setVisibility(0);
                this.cMV.startLoad(str3, 10, false);
                this.cMV.setTag(0);
                return;
            }
            this.cMU.setVisibility(8);
        }
    }

    @Override // com.baidu.tieba.tbadkCore.o
    public boolean b(TbPageContext<?> tbPageContext, int i) {
        com.baidu.tbadk.core.c layoutMode = getPageContext().getLayoutMode();
        layoutMode.setNightMode(i == 1);
        layoutMode.onModeChanged(getRootView());
        return true;
    }
}
