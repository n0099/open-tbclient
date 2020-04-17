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
/* loaded from: classes10.dex */
public class c extends com.baidu.tbadk.mvc.f.a<tinfo, com.baidu.tbadk.mvc.d.b> {
    private View.OnClickListener aOK;
    private TextView dkk;
    private TextView gug;
    private TextView guh;
    private TextView gul;
    private RelativeLayout gup;
    private TbImageView guq;
    private TbImageView gur;
    private TbImageView gus;

    public c(TbPageContext<?> tbPageContext, View view, ViewEventCenter viewEventCenter) {
        super(tbPageContext, view, viewEventCenter);
        this.aOK = new View.OnClickListener() { // from class: com.baidu.tieba.chosen.posts.a.c.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                Object tag = view2.getTag();
                if (tag instanceof Integer) {
                    com.baidu.tbadk.mvc.c.b bVar = new com.baidu.tbadk.mvc.c.b(4096, new d(((Integer) tag).intValue(), c.this.getData()), null, null);
                    bVar.setUniqueId(c.this.getUniqueId());
                    c.this.aZe().dispatchMvcEvent(bVar);
                }
            }
        };
        this.dkk = (TextView) view.findViewById(R.id.chosen_picture_title);
        this.gug = (TextView) view.findViewById(R.id.chosen_picture_praise);
        this.guh = (TextView) view.findViewById(R.id.chosen_picture_comment);
        this.gul = (TextView) view.findViewById(R.id.chosen_picture_head);
        this.gup = (RelativeLayout) view.findViewById(R.id.chosen_picture_pic_container);
        this.guq = (TbImageView) view.findViewById(R.id.chosen_picture_pic_one);
        this.gur = (TbImageView) view.findViewById(R.id.chosen_picture_pic_two);
        this.gus = (TbImageView) view.findViewById(R.id.chosen_picture_pic_thr);
        this.guq.setOnClickListener(this.aOK);
        this.gur.setOnClickListener(this.aOK);
        this.gus.setOnClickListener(this.aOK);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.mvc.f.e
    /* renamed from: a */
    public void ai(final tinfo tinfoVar) {
        super.ai(tinfoVar);
        if (tinfoVar != null) {
            if (StringUtils.isNull(tinfoVar.forum_name)) {
                this.dkk.setVisibility(8);
            } else {
                this.dkk.setVisibility(0);
                this.dkk.setText(UtilHelper.getFixedText(getContext().getString(R.string.chosen_pb_original_bar, tinfoVar.forum_name), 7, false));
                this.dkk.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.chosen.posts.a.c.2
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
                this.gul.setVisibility(8);
            } else {
                this.gul.setVisibility(0);
                this.gul.setText(tinfoVar.title);
            }
            if (tinfoVar.zan_num == null) {
                this.gug.setVisibility(8);
            } else {
                this.gug.setVisibility(0);
                this.gug.setText(tinfoVar.zan_num + "");
            }
            if (tinfoVar.reply_num == null) {
                this.guh.setVisibility(8);
            } else {
                this.guh.setVisibility(0);
                this.guh.setText(tinfoVar.reply_num + "");
            }
            b(tinfoVar);
        }
    }

    private void b(tinfo tinfoVar) {
        if (tinfoVar != null) {
            if (i.aIe().isShowImages() && tinfoVar.pics != null && tinfoVar.pics.size() > 0) {
                this.gup.setVisibility(0);
                switch (tinfoVar.pics.size()) {
                    case 0:
                    default:
                        return;
                    case 1:
                        break;
                    case 3:
                        String str = tinfoVar.pics.get(2).small_pic;
                        this.gus.setVisibility(0);
                        this.gus.startLoad(str, 10, false);
                        this.gus.setTag(2);
                    case 2:
                        String str2 = tinfoVar.pics.get(1).small_pic;
                        this.gur.setVisibility(0);
                        this.gur.startLoad(str2, 10, false);
                        this.gur.setTag(1);
                        break;
                }
                String str3 = tinfoVar.pics.get(0).small_pic;
                this.guq.setVisibility(0);
                this.guq.startLoad(str3, 10, false);
                this.guq.setTag(0);
                return;
            }
            this.gup.setVisibility(8);
        }
    }

    @Override // com.baidu.tieba.tbadkCore.r
    public boolean b(TbPageContext<?> tbPageContext, int i) {
        com.baidu.tbadk.core.c layoutMode = getPageContext().getLayoutMode();
        layoutMode.setNightMode(i == 1);
        layoutMode.onModeChanged(getRootView());
        return true;
    }
}
