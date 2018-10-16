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
    private TextView aiy;
    private TextView cVd;
    private TextView cVe;
    private TextView cVi;
    private RelativeLayout cVm;
    private TbImageView cVn;
    private TbImageView cVo;
    private TbImageView cVp;
    private View.OnClickListener coI;

    public c(TbPageContext<?> tbPageContext, View view, ViewEventCenter viewEventCenter) {
        super(tbPageContext, view, viewEventCenter);
        this.coI = new View.OnClickListener() { // from class: com.baidu.tieba.chosen.posts.a.c.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                Object tag = view2.getTag();
                if (tag instanceof Integer) {
                    com.baidu.tbadk.mvc.c.b bVar = new com.baidu.tbadk.mvc.c.b(4096, new d(((Integer) tag).intValue(), c.this.getData()), null, null);
                    bVar.setUniqueId(c.this.getUniqueId());
                    c.this.Ny().dispatchMvcEvent(bVar);
                }
            }
        };
        this.aiy = (TextView) view.findViewById(e.g.chosen_picture_title);
        this.cVd = (TextView) view.findViewById(e.g.chosen_picture_praise);
        this.cVe = (TextView) view.findViewById(e.g.chosen_picture_comment);
        this.cVi = (TextView) view.findViewById(e.g.chosen_picture_head);
        this.cVm = (RelativeLayout) view.findViewById(e.g.chosen_picture_pic_container);
        this.cVn = (TbImageView) view.findViewById(e.g.chosen_picture_pic_one);
        this.cVo = (TbImageView) view.findViewById(e.g.chosen_picture_pic_two);
        this.cVp = (TbImageView) view.findViewById(e.g.chosen_picture_pic_thr);
        this.cVn.setOnClickListener(this.coI);
        this.cVo.setOnClickListener(this.coI);
        this.cVp.setOnClickListener(this.coI);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.mvc.f.e
    /* renamed from: a */
    public void L(final tinfo tinfoVar) {
        super.L(tinfoVar);
        if (tinfoVar != null) {
            if (StringUtils.isNull(tinfoVar.forum_name)) {
                this.aiy.setVisibility(8);
            } else {
                this.aiy.setVisibility(0);
                this.aiy.setText(UtilHelper.getFixedText(getContext().getString(e.j.chosen_pb_original_bar, tinfoVar.forum_name), 7, false));
                this.aiy.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.chosen.posts.a.c.2
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
                this.cVi.setVisibility(8);
            } else {
                this.cVi.setVisibility(0);
                this.cVi.setText(tinfoVar.title);
            }
            if (tinfoVar.zan_num == null) {
                this.cVd.setVisibility(8);
            } else {
                this.cVd.setVisibility(0);
                this.cVd.setText(tinfoVar.zan_num + "");
            }
            if (tinfoVar.reply_num == null) {
                this.cVe.setVisibility(8);
            } else {
                this.cVe.setVisibility(0);
                this.cVe.setText(tinfoVar.reply_num + "");
            }
            b(tinfoVar);
        }
    }

    private void b(tinfo tinfoVar) {
        if (tinfoVar != null) {
            if (i.ws().ww() && tinfoVar.pics != null && tinfoVar.pics.size() > 0) {
                this.cVm.setVisibility(0);
                switch (tinfoVar.pics.size()) {
                    case 0:
                    default:
                        return;
                    case 1:
                        break;
                    case 3:
                        String str = tinfoVar.pics.get(2).small_pic;
                        this.cVp.setVisibility(0);
                        this.cVp.startLoad(str, 10, false);
                        this.cVp.setTag(2);
                    case 2:
                        String str2 = tinfoVar.pics.get(1).small_pic;
                        this.cVo.setVisibility(0);
                        this.cVo.startLoad(str2, 10, false);
                        this.cVo.setTag(1);
                        break;
                }
                String str3 = tinfoVar.pics.get(0).small_pic;
                this.cVn.setVisibility(0);
                this.cVn.startLoad(str3, 10, false);
                this.cVn.setTag(0);
                return;
            }
            this.cVm.setVisibility(8);
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
