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
import com.baidu.tieba.R;
import tbclient.HotThread.tinfo;
/* loaded from: classes5.dex */
public class c extends com.baidu.tbadk.mvc.f.a<tinfo, com.baidu.tbadk.mvc.d.b> {
    private TextView bBh;
    private View.OnClickListener dSP;
    private TextView eFO;
    private TextView eFP;
    private TextView eFT;
    private RelativeLayout eFX;
    private TbImageView eFY;
    private TbImageView eFZ;
    private TbImageView eGa;

    public c(TbPageContext<?> tbPageContext, View view, ViewEventCenter viewEventCenter) {
        super(tbPageContext, view, viewEventCenter);
        this.dSP = new View.OnClickListener() { // from class: com.baidu.tieba.chosen.posts.a.c.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                Object tag = view2.getTag();
                if (tag instanceof Integer) {
                    com.baidu.tbadk.mvc.c.b bVar = new com.baidu.tbadk.mvc.c.b(4096, new d(((Integer) tag).intValue(), c.this.getData()), null, null);
                    bVar.setUniqueId(c.this.getUniqueId());
                    c.this.atK().dispatchMvcEvent(bVar);
                }
            }
        };
        this.bBh = (TextView) view.findViewById(R.id.chosen_picture_title);
        this.eFO = (TextView) view.findViewById(R.id.chosen_picture_praise);
        this.eFP = (TextView) view.findViewById(R.id.chosen_picture_comment);
        this.eFT = (TextView) view.findViewById(R.id.chosen_picture_head);
        this.eFX = (RelativeLayout) view.findViewById(R.id.chosen_picture_pic_container);
        this.eFY = (TbImageView) view.findViewById(R.id.chosen_picture_pic_one);
        this.eFZ = (TbImageView) view.findViewById(R.id.chosen_picture_pic_two);
        this.eGa = (TbImageView) view.findViewById(R.id.chosen_picture_pic_thr);
        this.eFY.setOnClickListener(this.dSP);
        this.eFZ.setOnClickListener(this.dSP);
        this.eGa.setOnClickListener(this.dSP);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.mvc.f.e
    /* renamed from: a */
    public void af(final tinfo tinfoVar) {
        super.af(tinfoVar);
        if (tinfoVar != null) {
            if (StringUtils.isNull(tinfoVar.forum_name)) {
                this.bBh.setVisibility(8);
            } else {
                this.bBh.setVisibility(0);
                this.bBh.setText(UtilHelper.getFixedText(getContext().getString(R.string.chosen_pb_original_bar, tinfoVar.forum_name), 7, false));
                this.bBh.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.chosen.posts.a.c.2
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
                this.eFT.setVisibility(8);
            } else {
                this.eFT.setVisibility(0);
                this.eFT.setText(tinfoVar.title);
            }
            if (tinfoVar.zan_num == null) {
                this.eFO.setVisibility(8);
            } else {
                this.eFO.setVisibility(0);
                this.eFO.setText(tinfoVar.zan_num + "");
            }
            if (tinfoVar.reply_num == null) {
                this.eFP.setVisibility(8);
            } else {
                this.eFP.setVisibility(0);
                this.eFP.setText(tinfoVar.reply_num + "");
            }
            b(tinfoVar);
        }
    }

    private void b(tinfo tinfoVar) {
        if (tinfoVar != null) {
            if (i.abb().abf() && tinfoVar.pics != null && tinfoVar.pics.size() > 0) {
                this.eFX.setVisibility(0);
                switch (tinfoVar.pics.size()) {
                    case 0:
                    default:
                        return;
                    case 1:
                        break;
                    case 3:
                        String str = tinfoVar.pics.get(2).small_pic;
                        this.eGa.setVisibility(0);
                        this.eGa.startLoad(str, 10, false);
                        this.eGa.setTag(2);
                    case 2:
                        String str2 = tinfoVar.pics.get(1).small_pic;
                        this.eFZ.setVisibility(0);
                        this.eFZ.startLoad(str2, 10, false);
                        this.eFZ.setTag(1);
                        break;
                }
                String str3 = tinfoVar.pics.get(0).small_pic;
                this.eFY.setVisibility(0);
                this.eFY.startLoad(str3, 10, false);
                this.eFY.setTag(0);
                return;
            }
            this.eFX.setVisibility(8);
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
