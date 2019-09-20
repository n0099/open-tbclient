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
    private TextView bCB;
    private View.OnClickListener dYB;
    private TextView eMA;
    private TextView eMB;
    private TextView eMF;
    private RelativeLayout eMJ;
    private TbImageView eMK;
    private TbImageView eML;
    private TbImageView eMM;

    public c(TbPageContext<?> tbPageContext, View view, ViewEventCenter viewEventCenter) {
        super(tbPageContext, view, viewEventCenter);
        this.dYB = new View.OnClickListener() { // from class: com.baidu.tieba.chosen.posts.a.c.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                Object tag = view2.getTag();
                if (tag instanceof Integer) {
                    com.baidu.tbadk.mvc.c.b bVar = new com.baidu.tbadk.mvc.c.b(4096, new d(((Integer) tag).intValue(), c.this.getData()), null, null);
                    bVar.setUniqueId(c.this.getUniqueId());
                    c.this.avg().dispatchMvcEvent(bVar);
                }
            }
        };
        this.bCB = (TextView) view.findViewById(R.id.chosen_picture_title);
        this.eMA = (TextView) view.findViewById(R.id.chosen_picture_praise);
        this.eMB = (TextView) view.findViewById(R.id.chosen_picture_comment);
        this.eMF = (TextView) view.findViewById(R.id.chosen_picture_head);
        this.eMJ = (RelativeLayout) view.findViewById(R.id.chosen_picture_pic_container);
        this.eMK = (TbImageView) view.findViewById(R.id.chosen_picture_pic_one);
        this.eML = (TbImageView) view.findViewById(R.id.chosen_picture_pic_two);
        this.eMM = (TbImageView) view.findViewById(R.id.chosen_picture_pic_thr);
        this.eMK.setOnClickListener(this.dYB);
        this.eML.setOnClickListener(this.dYB);
        this.eMM.setOnClickListener(this.dYB);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.mvc.f.e
    /* renamed from: a */
    public void af(final tinfo tinfoVar) {
        super.af(tinfoVar);
        if (tinfoVar != null) {
            if (StringUtils.isNull(tinfoVar.forum_name)) {
                this.bCB.setVisibility(8);
            } else {
                this.bCB.setVisibility(0);
                this.bCB.setText(UtilHelper.getFixedText(getContext().getString(R.string.chosen_pb_original_bar, tinfoVar.forum_name), 7, false));
                this.bCB.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.chosen.posts.a.c.2
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
                this.eMF.setVisibility(8);
            } else {
                this.eMF.setVisibility(0);
                this.eMF.setText(tinfoVar.title);
            }
            if (tinfoVar.zan_num == null) {
                this.eMA.setVisibility(8);
            } else {
                this.eMA.setVisibility(0);
                this.eMA.setText(tinfoVar.zan_num + "");
            }
            if (tinfoVar.reply_num == null) {
                this.eMB.setVisibility(8);
            } else {
                this.eMB.setVisibility(0);
                this.eMB.setText(tinfoVar.reply_num + "");
            }
            b(tinfoVar);
        }
    }

    private void b(tinfo tinfoVar) {
        if (tinfoVar != null) {
            if (i.ace().aci() && tinfoVar.pics != null && tinfoVar.pics.size() > 0) {
                this.eMJ.setVisibility(0);
                switch (tinfoVar.pics.size()) {
                    case 0:
                    default:
                        return;
                    case 1:
                        break;
                    case 3:
                        String str = tinfoVar.pics.get(2).small_pic;
                        this.eMM.setVisibility(0);
                        this.eMM.startLoad(str, 10, false);
                        this.eMM.setTag(2);
                    case 2:
                        String str2 = tinfoVar.pics.get(1).small_pic;
                        this.eML.setVisibility(0);
                        this.eML.startLoad(str2, 10, false);
                        this.eML.setTag(1);
                        break;
                }
                String str3 = tinfoVar.pics.get(0).small_pic;
                this.eMK.setVisibility(0);
                this.eMK.startLoad(str3, 10, false);
                this.eMK.setTag(0);
                return;
            }
            this.eMJ.setVisibility(8);
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
