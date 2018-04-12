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
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.mvc.core.ViewEventCenter;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.d;
import tbclient.HotThread.tinfo;
/* loaded from: classes3.dex */
public class c extends com.baidu.tbadk.mvc.f.a<tinfo, com.baidu.tbadk.mvc.d.b> {
    private TextView Tm;
    private View.OnClickListener bOj;
    private TextView cwP;
    private TextView cwQ;
    private TextView cwU;
    private RelativeLayout cwY;
    private TbImageView cwZ;
    private TbImageView cxa;
    private TbImageView cxb;

    public c(TbPageContext<?> tbPageContext, View view2, ViewEventCenter viewEventCenter) {
        super(tbPageContext, view2, viewEventCenter);
        this.bOj = new View.OnClickListener() { // from class: com.baidu.tieba.chosen.posts.a.c.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view3) {
                Object tag = view3.getTag();
                if (tag instanceof Integer) {
                    com.baidu.tbadk.mvc.c.b bVar = new com.baidu.tbadk.mvc.c.b(4096, new d(((Integer) tag).intValue(), c.this.getData()), null, null);
                    bVar.setUniqueId(c.this.getUniqueId());
                    c.this.Gn().dispatchMvcEvent(bVar);
                }
            }
        };
        this.Tm = (TextView) view2.findViewById(d.g.chosen_picture_title);
        this.cwP = (TextView) view2.findViewById(d.g.chosen_picture_praise);
        this.cwQ = (TextView) view2.findViewById(d.g.chosen_picture_comment);
        this.cwU = (TextView) view2.findViewById(d.g.chosen_picture_head);
        this.cwY = (RelativeLayout) view2.findViewById(d.g.chosen_picture_pic_container);
        this.cwZ = (TbImageView) view2.findViewById(d.g.chosen_picture_pic_one);
        this.cxa = (TbImageView) view2.findViewById(d.g.chosen_picture_pic_two);
        this.cxb = (TbImageView) view2.findViewById(d.g.chosen_picture_pic_thr);
        this.cwZ.setOnClickListener(this.bOj);
        this.cxa.setOnClickListener(this.bOj);
        this.cxb.setOnClickListener(this.bOj);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.mvc.f.e
    /* renamed from: a */
    public void D(final tinfo tinfoVar) {
        super.D(tinfoVar);
        if (tinfoVar != null) {
            if (StringUtils.isNull(tinfoVar.forum_name)) {
                this.Tm.setVisibility(8);
            } else {
                this.Tm.setVisibility(0);
                this.Tm.setText(UtilHelper.getFixedText(getContext().getString(d.k.chosen_pb_original_bar, tinfoVar.forum_name), 7, false));
                this.Tm.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.chosen.posts.a.c.2
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view2) {
                        String str = tinfoVar.forum_name;
                        if (an.aQ(str)) {
                            TiebaStatic.eventStat(c.this.getActivity(), "kantie_6", null, 1, new Object[0]);
                            MessageManager.getInstance().sendMessage(new CustomMessage(2003000, new FrsActivityConfig(c.this.getActivity()).createNormalCfg(str, FrsActivityConfig.FRS_FROM_RECOMMEND)));
                        }
                    }
                });
            }
            if (StringUtils.isNull(tinfoVar.title)) {
                this.cwU.setVisibility(8);
            } else {
                this.cwU.setVisibility(0);
                this.cwU.setText(tinfoVar.title);
            }
            if (tinfoVar.zan_num == null) {
                this.cwP.setVisibility(8);
            } else {
                this.cwP.setVisibility(0);
                this.cwP.setText(tinfoVar.zan_num + "");
            }
            if (tinfoVar.reply_num == null) {
                this.cwQ.setVisibility(8);
            } else {
                this.cwQ.setVisibility(0);
                this.cwQ.setText(tinfoVar.reply_num + "");
            }
            b(tinfoVar);
        }
    }

    private void b(tinfo tinfoVar) {
        if (tinfoVar != null) {
            if (i.pY().qe() && tinfoVar.pics != null && tinfoVar.pics.size() > 0) {
                this.cwY.setVisibility(0);
                switch (tinfoVar.pics.size()) {
                    case 0:
                    default:
                        return;
                    case 1:
                        break;
                    case 3:
                        String str = tinfoVar.pics.get(2).small_pic;
                        this.cxb.setVisibility(0);
                        this.cxb.startLoad(str, 10, false);
                        this.cxb.setTag(2);
                    case 2:
                        String str2 = tinfoVar.pics.get(1).small_pic;
                        this.cxa.setVisibility(0);
                        this.cxa.startLoad(str2, 10, false);
                        this.cxa.setTag(1);
                        break;
                }
                String str3 = tinfoVar.pics.get(0).small_pic;
                this.cwZ.setVisibility(0);
                this.cwZ.startLoad(str3, 10, false);
                this.cwZ.setTag(0);
                return;
            }
            this.cwY.setVisibility(8);
        }
    }

    @Override // com.baidu.tieba.tbadkCore.o
    public boolean b(TbPageContext<?> tbPageContext, int i) {
        com.baidu.tbadk.core.c layoutMode = getPageContext().getLayoutMode();
        layoutMode.setNightMode(i == 1);
        layoutMode.u(getRootView());
        return true;
    }
}
