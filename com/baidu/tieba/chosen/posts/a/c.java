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
import com.baidu.tieba.d;
import tbclient.HotThread.tinfo;
/* loaded from: classes5.dex */
public class c extends com.baidu.tbadk.mvc.f.a<tinfo, com.baidu.tbadk.mvc.d.b> {
    private TextView btZ;
    private View.OnClickListener dIW;
    private RelativeLayout eqC;
    private TbImageView eqD;
    private TbImageView eqE;
    private TbImageView eqF;
    private TextView eqt;
    private TextView equ;
    private TextView eqy;

    public c(TbPageContext<?> tbPageContext, View view, ViewEventCenter viewEventCenter) {
        super(tbPageContext, view, viewEventCenter);
        this.dIW = new View.OnClickListener() { // from class: com.baidu.tieba.chosen.posts.a.c.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                Object tag = view2.getTag();
                if (tag instanceof Integer) {
                    com.baidu.tbadk.mvc.c.b bVar = new com.baidu.tbadk.mvc.c.b(4096, new d(((Integer) tag).intValue(), c.this.getData()), null, null);
                    bVar.setUniqueId(c.this.getUniqueId());
                    c.this.aoJ().dispatchMvcEvent(bVar);
                }
            }
        };
        this.btZ = (TextView) view.findViewById(d.g.chosen_picture_title);
        this.eqt = (TextView) view.findViewById(d.g.chosen_picture_praise);
        this.equ = (TextView) view.findViewById(d.g.chosen_picture_comment);
        this.eqy = (TextView) view.findViewById(d.g.chosen_picture_head);
        this.eqC = (RelativeLayout) view.findViewById(d.g.chosen_picture_pic_container);
        this.eqD = (TbImageView) view.findViewById(d.g.chosen_picture_pic_one);
        this.eqE = (TbImageView) view.findViewById(d.g.chosen_picture_pic_two);
        this.eqF = (TbImageView) view.findViewById(d.g.chosen_picture_pic_thr);
        this.eqD.setOnClickListener(this.dIW);
        this.eqE.setOnClickListener(this.dIW);
        this.eqF.setOnClickListener(this.dIW);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.mvc.f.e
    /* renamed from: a */
    public void af(final tinfo tinfoVar) {
        super.af(tinfoVar);
        if (tinfoVar != null) {
            if (StringUtils.isNull(tinfoVar.forum_name)) {
                this.btZ.setVisibility(8);
            } else {
                this.btZ.setVisibility(0);
                this.btZ.setText(UtilHelper.getFixedText(getContext().getString(d.j.chosen_pb_original_bar, tinfoVar.forum_name), 7, false));
                this.btZ.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.chosen.posts.a.c.2
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        String str = tinfoVar.forum_name;
                        if (ap.bv(str)) {
                            TiebaStatic.eventStat(c.this.getActivity(), "kantie_6", null, 1, new Object[0]);
                            MessageManager.getInstance().sendMessage(new CustomMessage(2003000, new FrsActivityConfig(c.this.getActivity()).createNormalCfg(str, FrsActivityConfig.FRS_FROM_RECOMMEND)));
                        }
                    }
                });
            }
            if (StringUtils.isNull(tinfoVar.title)) {
                this.eqy.setVisibility(8);
            } else {
                this.eqy.setVisibility(0);
                this.eqy.setText(tinfoVar.title);
            }
            if (tinfoVar.zan_num == null) {
                this.eqt.setVisibility(8);
            } else {
                this.eqt.setVisibility(0);
                this.eqt.setText(tinfoVar.zan_num + "");
            }
            if (tinfoVar.reply_num == null) {
                this.equ.setVisibility(8);
            } else {
                this.equ.setVisibility(0);
                this.equ.setText(tinfoVar.reply_num + "");
            }
            b(tinfoVar);
        }
    }

    private void b(tinfo tinfoVar) {
        if (tinfoVar != null) {
            if (i.Wy().WC() && tinfoVar.pics != null && tinfoVar.pics.size() > 0) {
                this.eqC.setVisibility(0);
                switch (tinfoVar.pics.size()) {
                    case 0:
                    default:
                        return;
                    case 1:
                        break;
                    case 3:
                        String str = tinfoVar.pics.get(2).small_pic;
                        this.eqF.setVisibility(0);
                        this.eqF.startLoad(str, 10, false);
                        this.eqF.setTag(2);
                    case 2:
                        String str2 = tinfoVar.pics.get(1).small_pic;
                        this.eqE.setVisibility(0);
                        this.eqE.startLoad(str2, 10, false);
                        this.eqE.setTag(1);
                        break;
                }
                String str3 = tinfoVar.pics.get(0).small_pic;
                this.eqD.setVisibility(0);
                this.eqD.startLoad(str3, 10, false);
                this.eqD.setTag(0);
                return;
            }
            this.eqC.setVisibility(8);
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
