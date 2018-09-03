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
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.mvc.core.ViewEventCenter;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.f;
import tbclient.HotThread.tinfo;
/* loaded from: classes3.dex */
public class c extends com.baidu.tbadk.mvc.f.a<tinfo, com.baidu.tbadk.mvc.d.b> {
    private TextView aaX;
    private TextView cGU;
    private TextView cGV;
    private TextView cGZ;
    private RelativeLayout cHd;
    private TbImageView cHe;
    private TbImageView cHf;
    private TbImageView cHg;
    private View.OnClickListener caq;

    public c(TbPageContext<?> tbPageContext, View view, ViewEventCenter viewEventCenter) {
        super(tbPageContext, view, viewEventCenter);
        this.caq = new View.OnClickListener() { // from class: com.baidu.tieba.chosen.posts.a.c.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                Object tag = view2.getTag();
                if (tag instanceof Integer) {
                    com.baidu.tbadk.mvc.c.b bVar = new com.baidu.tbadk.mvc.c.b(4096, new d(((Integer) tag).intValue(), c.this.getData()), null, null);
                    bVar.setUniqueId(c.this.getUniqueId());
                    c.this.Kk().dispatchMvcEvent(bVar);
                }
            }
        };
        this.aaX = (TextView) view.findViewById(f.g.chosen_picture_title);
        this.cGU = (TextView) view.findViewById(f.g.chosen_picture_praise);
        this.cGV = (TextView) view.findViewById(f.g.chosen_picture_comment);
        this.cGZ = (TextView) view.findViewById(f.g.chosen_picture_head);
        this.cHd = (RelativeLayout) view.findViewById(f.g.chosen_picture_pic_container);
        this.cHe = (TbImageView) view.findViewById(f.g.chosen_picture_pic_one);
        this.cHf = (TbImageView) view.findViewById(f.g.chosen_picture_pic_two);
        this.cHg = (TbImageView) view.findViewById(f.g.chosen_picture_pic_thr);
        this.cHe.setOnClickListener(this.caq);
        this.cHf.setOnClickListener(this.caq);
        this.cHg.setOnClickListener(this.caq);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.mvc.f.e
    /* renamed from: a */
    public void G(final tinfo tinfoVar) {
        super.G(tinfoVar);
        if (tinfoVar != null) {
            if (StringUtils.isNull(tinfoVar.forum_name)) {
                this.aaX.setVisibility(8);
            } else {
                this.aaX.setVisibility(0);
                this.aaX.setText(UtilHelper.getFixedText(getContext().getString(f.j.chosen_pb_original_bar, tinfoVar.forum_name), 7, false));
                this.aaX.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.chosen.posts.a.c.2
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        String str = tinfoVar.forum_name;
                        if (ap.bf(str)) {
                            TiebaStatic.eventStat(c.this.getActivity(), "kantie_6", null, 1, new Object[0]);
                            MessageManager.getInstance().sendMessage(new CustomMessage(2003000, new FrsActivityConfig(c.this.getActivity()).createNormalCfg(str, FrsActivityConfig.FRS_FROM_RECOMMEND)));
                        }
                    }
                });
            }
            if (StringUtils.isNull(tinfoVar.title)) {
                this.cGZ.setVisibility(8);
            } else {
                this.cGZ.setVisibility(0);
                this.cGZ.setText(tinfoVar.title);
            }
            if (tinfoVar.zan_num == null) {
                this.cGU.setVisibility(8);
            } else {
                this.cGU.setVisibility(0);
                this.cGU.setText(tinfoVar.zan_num + "");
            }
            if (tinfoVar.reply_num == null) {
                this.cGV.setVisibility(8);
            } else {
                this.cGV.setVisibility(0);
                this.cGV.setText(tinfoVar.reply_num + "");
            }
            b(tinfoVar);
        }
    }

    private void b(tinfo tinfoVar) {
        if (tinfoVar != null) {
            if (i.td().tj() && tinfoVar.pics != null && tinfoVar.pics.size() > 0) {
                this.cHd.setVisibility(0);
                switch (tinfoVar.pics.size()) {
                    case 0:
                    default:
                        return;
                    case 1:
                        break;
                    case 3:
                        String str = tinfoVar.pics.get(2).small_pic;
                        this.cHg.setVisibility(0);
                        this.cHg.startLoad(str, 10, false);
                        this.cHg.setTag(2);
                    case 2:
                        String str2 = tinfoVar.pics.get(1).small_pic;
                        this.cHf.setVisibility(0);
                        this.cHf.startLoad(str2, 10, false);
                        this.cHf.setTag(1);
                        break;
                }
                String str3 = tinfoVar.pics.get(0).small_pic;
                this.cHe.setVisibility(0);
                this.cHe.startLoad(str3, 10, false);
                this.cHe.setTag(0);
                return;
            }
            this.cHd.setVisibility(8);
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
