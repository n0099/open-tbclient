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
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.mvc.core.ViewEventCenter;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import tbclient.HotThread.tinfo;
/* loaded from: classes5.dex */
public class c extends com.baidu.tbadk.mvc.f.a<tinfo, com.baidu.tbadk.mvc.d.b> {
    private TextView bCd;
    private View.OnClickListener dWR;
    private TextView eKR;
    private TextView eKS;
    private TextView eKW;
    private RelativeLayout eLa;
    private TbImageView eLb;
    private TbImageView eLc;
    private TbImageView eLd;

    public c(TbPageContext<?> tbPageContext, View view, ViewEventCenter viewEventCenter) {
        super(tbPageContext, view, viewEventCenter);
        this.dWR = new View.OnClickListener() { // from class: com.baidu.tieba.chosen.posts.a.c.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                Object tag = view2.getTag();
                if (tag instanceof Integer) {
                    com.baidu.tbadk.mvc.c.b bVar = new com.baidu.tbadk.mvc.c.b(4096, new d(((Integer) tag).intValue(), c.this.getData()), null, null);
                    bVar.setUniqueId(c.this.getUniqueId());
                    c.this.auU().dispatchMvcEvent(bVar);
                }
            }
        };
        this.bCd = (TextView) view.findViewById(R.id.chosen_picture_title);
        this.eKR = (TextView) view.findViewById(R.id.chosen_picture_praise);
        this.eKS = (TextView) view.findViewById(R.id.chosen_picture_comment);
        this.eKW = (TextView) view.findViewById(R.id.chosen_picture_head);
        this.eLa = (RelativeLayout) view.findViewById(R.id.chosen_picture_pic_container);
        this.eLb = (TbImageView) view.findViewById(R.id.chosen_picture_pic_one);
        this.eLc = (TbImageView) view.findViewById(R.id.chosen_picture_pic_two);
        this.eLd = (TbImageView) view.findViewById(R.id.chosen_picture_pic_thr);
        this.eLb.setOnClickListener(this.dWR);
        this.eLc.setOnClickListener(this.dWR);
        this.eLd.setOnClickListener(this.dWR);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.mvc.f.e
    /* renamed from: a */
    public void af(final tinfo tinfoVar) {
        super.af(tinfoVar);
        if (tinfoVar != null) {
            if (StringUtils.isNull(tinfoVar.forum_name)) {
                this.bCd.setVisibility(8);
            } else {
                this.bCd.setVisibility(0);
                this.bCd.setText(UtilHelper.getFixedText(getContext().getString(R.string.chosen_pb_original_bar, tinfoVar.forum_name), 7, false));
                this.bCd.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.chosen.posts.a.c.2
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        String str = tinfoVar.forum_name;
                        if (aq.bg(str)) {
                            TiebaStatic.eventStat(c.this.getActivity(), "kantie_6", null, 1, new Object[0]);
                            MessageManager.getInstance().sendMessage(new CustomMessage(2003000, new FrsActivityConfig(c.this.getActivity()).createNormalCfg(str, FrsActivityConfig.FRS_FROM_RECOMMEND)));
                        }
                    }
                });
            }
            if (StringUtils.isNull(tinfoVar.title)) {
                this.eKW.setVisibility(8);
            } else {
                this.eKW.setVisibility(0);
                this.eKW.setText(tinfoVar.title);
            }
            if (tinfoVar.zan_num == null) {
                this.eKR.setVisibility(8);
            } else {
                this.eKR.setVisibility(0);
                this.eKR.setText(tinfoVar.zan_num + "");
            }
            if (tinfoVar.reply_num == null) {
                this.eKS.setVisibility(8);
            } else {
                this.eKS.setVisibility(0);
                this.eKS.setText(tinfoVar.reply_num + "");
            }
            b(tinfoVar);
        }
    }

    private void b(tinfo tinfoVar) {
        if (tinfoVar != null) {
            if (i.aca().ace() && tinfoVar.pics != null && tinfoVar.pics.size() > 0) {
                this.eLa.setVisibility(0);
                switch (tinfoVar.pics.size()) {
                    case 0:
                    default:
                        return;
                    case 1:
                        break;
                    case 3:
                        String str = tinfoVar.pics.get(2).small_pic;
                        this.eLd.setVisibility(0);
                        this.eLd.startLoad(str, 10, false);
                        this.eLd.setTag(2);
                    case 2:
                        String str2 = tinfoVar.pics.get(1).small_pic;
                        this.eLc.setVisibility(0);
                        this.eLc.startLoad(str2, 10, false);
                        this.eLc.setTag(1);
                        break;
                }
                String str3 = tinfoVar.pics.get(0).small_pic;
                this.eLb.setVisibility(0);
                this.eLb.startLoad(str3, 10, false);
                this.eLb.setTag(0);
                return;
            }
            this.eLa.setVisibility(8);
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
