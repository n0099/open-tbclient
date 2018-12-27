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
    private TextView amN;
    private View.OnClickListener cts;
    private TextView dfL;
    private TextView dfM;
    private TextView dfQ;
    private RelativeLayout dfU;
    private TbImageView dfV;
    private TbImageView dfW;
    private TbImageView dfX;

    public c(TbPageContext<?> tbPageContext, View view, ViewEventCenter viewEventCenter) {
        super(tbPageContext, view, viewEventCenter);
        this.cts = new View.OnClickListener() { // from class: com.baidu.tieba.chosen.posts.a.c.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                Object tag = view2.getTag();
                if (tag instanceof Integer) {
                    com.baidu.tbadk.mvc.c.b bVar = new com.baidu.tbadk.mvc.c.b(4096, new d(((Integer) tag).intValue(), c.this.getData()), null, null);
                    bVar.setUniqueId(c.this.getUniqueId());
                    c.this.OM().dispatchMvcEvent(bVar);
                }
            }
        };
        this.amN = (TextView) view.findViewById(e.g.chosen_picture_title);
        this.dfL = (TextView) view.findViewById(e.g.chosen_picture_praise);
        this.dfM = (TextView) view.findViewById(e.g.chosen_picture_comment);
        this.dfQ = (TextView) view.findViewById(e.g.chosen_picture_head);
        this.dfU = (RelativeLayout) view.findViewById(e.g.chosen_picture_pic_container);
        this.dfV = (TbImageView) view.findViewById(e.g.chosen_picture_pic_one);
        this.dfW = (TbImageView) view.findViewById(e.g.chosen_picture_pic_two);
        this.dfX = (TbImageView) view.findViewById(e.g.chosen_picture_pic_thr);
        this.dfV.setOnClickListener(this.cts);
        this.dfW.setOnClickListener(this.cts);
        this.dfX.setOnClickListener(this.cts);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.mvc.f.e
    /* renamed from: a */
    public void L(final tinfo tinfoVar) {
        super.L(tinfoVar);
        if (tinfoVar != null) {
            if (StringUtils.isNull(tinfoVar.forum_name)) {
                this.amN.setVisibility(8);
            } else {
                this.amN.setVisibility(0);
                this.amN.setText(UtilHelper.getFixedText(getContext().getString(e.j.chosen_pb_original_bar, tinfoVar.forum_name), 7, false));
                this.amN.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.chosen.posts.a.c.2
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        String str = tinfoVar.forum_name;
                        if (ao.bv(str)) {
                            TiebaStatic.eventStat(c.this.getActivity(), "kantie_6", null, 1, new Object[0]);
                            MessageManager.getInstance().sendMessage(new CustomMessage(2003000, new FrsActivityConfig(c.this.getActivity()).createNormalCfg(str, FrsActivityConfig.FRS_FROM_RECOMMEND)));
                        }
                    }
                });
            }
            if (StringUtils.isNull(tinfoVar.title)) {
                this.dfQ.setVisibility(8);
            } else {
                this.dfQ.setVisibility(0);
                this.dfQ.setText(tinfoVar.title);
            }
            if (tinfoVar.zan_num == null) {
                this.dfL.setVisibility(8);
            } else {
                this.dfL.setVisibility(0);
                this.dfL.setText(tinfoVar.zan_num + "");
            }
            if (tinfoVar.reply_num == null) {
                this.dfM.setVisibility(8);
            } else {
                this.dfM.setVisibility(0);
                this.dfM.setText(tinfoVar.reply_num + "");
            }
            b(tinfoVar);
        }
    }

    private void b(tinfo tinfoVar) {
        if (tinfoVar != null) {
            if (i.xE().xI() && tinfoVar.pics != null && tinfoVar.pics.size() > 0) {
                this.dfU.setVisibility(0);
                switch (tinfoVar.pics.size()) {
                    case 0:
                    default:
                        return;
                    case 1:
                        break;
                    case 3:
                        String str = tinfoVar.pics.get(2).small_pic;
                        this.dfX.setVisibility(0);
                        this.dfX.startLoad(str, 10, false);
                        this.dfX.setTag(2);
                    case 2:
                        String str2 = tinfoVar.pics.get(1).small_pic;
                        this.dfW.setVisibility(0);
                        this.dfW.startLoad(str2, 10, false);
                        this.dfW.setTag(1);
                        break;
                }
                String str3 = tinfoVar.pics.get(0).small_pic;
                this.dfV.setVisibility(0);
                this.dfV.startLoad(str3, 10, false);
                this.dfV.setTag(0);
                return;
            }
            this.dfU.setVisibility(8);
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
