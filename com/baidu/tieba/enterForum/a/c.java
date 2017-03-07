package com.baidu.tieba.enterForum.a;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.lib.util.k;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.FrsActivityConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.BitmapHelper;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.util.au;
import com.baidu.tbadk.core.util.x;
import com.baidu.tbadk.core.view.BarImageView;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.data.e;
import com.baidu.tieba.w;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class c extends BaseAdapter implements View.OnClickListener {
    private List<e> aVq;
    private TbPageContext aaI;

    public void a(List<e> list, TbPageContext<?> tbPageContext) {
        this.aVq = list;
        this.aaI = tbPageContext;
        notifyDataSetChanged();
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.aVq == null || this.aVq.size() <= 0) {
            return 0;
        }
        return this.aVq.size();
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return 0L;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: hh */
    public e getItem(int i) {
        if (this.aVq == null || this.aVq.size() <= 0 || this.aVq.size() <= i) {
            return null;
        }
        return this.aVq.get(i);
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        a aVar;
        if (view == null || view.getTag() == null || !(view.getTag() instanceof a)) {
            view = LayoutInflater.from(this.aaI.getPageActivity()).inflate(w.j.frequently_forum_info_item, (ViewGroup) null);
            a aVar2 = new a(this, null);
            aVar2.bDL = (LinearLayout) view.findViewById(w.h.frequently_forum_info_item);
            aVar2.bDM = (BarImageView) view.findViewById(w.h.frequently_forum_icon);
            aVar2.bDN = (TextView) view.findViewById(w.h.forum_name);
            aVar2.bDO = (ImageView) view.findViewById(w.h.level_info);
            aVar2.bDP = (ImageView) view.findViewById(w.h.sign_icon);
            aVar2.bDQ = (TextView) view.findViewById(w.h.new_thread_count);
            aVar2.bDU = (TextView) view.findViewById(w.h.post_thread_count);
            aVar2.bDR = (HeadImageView) view.findViewById(w.h.post_thread_person_one);
            aVar2.bDS = (HeadImageView) view.findViewById(w.h.post_thread_person_two);
            aVar2.bDT = (HeadImageView) view.findViewById(w.h.post_thread_person_three);
            aVar2.bDV = (LinearLayout) view.findViewById(w.h.new_thread);
            aVar2.bDW = (LinearLayout) view.findViewById(w.h.post_thread);
            aVar2.bDX = (TextView) view.findViewById(w.h.new_thread_describe);
            aVar2.bDY = (TextView) view.findViewById(w.h.post_thread_describe);
            view.setTag(aVar2);
            aVar = aVar2;
        } else {
            aVar = (a) view.getTag();
        }
        e item = getItem(i);
        if (item != null) {
            aVar.bDM.c(item.Cd(), 10, false);
            aVar.bDN.setText(TbadkCoreApplication.m9getInst().getString(w.l.chosen_pb_original_bar, new Object[]{UtilHelper.getFixedText(item.getForumName(), 6, true)}));
            aq.j(aVar.bDO, BitmapHelper.getGradeResourceIdNew(item.Cf()));
            if (StringUtils.isNull(item.Ce()) || com.baidu.adp.lib.g.b.g(item.Ce(), 0) == 0) {
                aVar.bDQ.setVisibility(8);
                aVar.bDX.setText(this.aaI.getResources().getString(w.l.zero_new_thread_describe));
            } else {
                aVar.bDQ.setVisibility(0);
                aVar.bDX.setText(this.aaI.getResources().getString(w.l.new_thread_describe));
                aVar.bDQ.setText(au.cQ(com.baidu.adp.lib.g.b.g(item.Ce(), 0)));
            }
            if (item.isSign()) {
                aVar.bDP.setVisibility(0);
            } else {
                aVar.bDP.setVisibility(8);
            }
            if (item.Cg() != null) {
                if (item.Cg().size() > 3) {
                    aVar.bDU.setVisibility(0);
                    aVar.bDU.setText("...");
                    aVar.bDY.setText(this.aaI.getResources().getString(w.l.post_thread_describe));
                } else if (item.Cg().size() <= 0) {
                    aVar.bDU.setVisibility(8);
                    aVar.bDY.setText(this.aaI.getResources().getString(w.l.attention_users_thread));
                } else {
                    aVar.bDY.setText(this.aaI.getResources().getString(w.l.post_thread_describe));
                    aVar.bDU.setVisibility(8);
                }
                aVar.bDR.setDefaultResource(17170445);
                aVar.bDR.setDefaultErrorResource(w.g.icon_default_avatar100);
                aVar.bDR.setDefaultBgResource(w.e.cp_bg_line_e);
                aVar.bDR.setRadius(k.g(this.aaI.getPageActivity(), w.f.ds70));
                aVar.bDS.setDefaultResource(17170445);
                aVar.bDS.setDefaultErrorResource(w.g.icon_default_avatar100);
                aVar.bDS.setDefaultBgResource(w.e.cp_bg_line_e);
                aVar.bDS.setRadius(k.g(this.aaI.getPageActivity(), w.f.ds70));
                aVar.bDT.setDefaultResource(17170445);
                aVar.bDT.setDefaultErrorResource(w.g.icon_default_avatar100);
                aVar.bDT.setDefaultBgResource(w.e.cp_bg_line_e);
                aVar.bDT.setRadius(k.g(this.aaI.getPageActivity(), w.f.ds70));
            }
            List<HeadImageView> arrayList = new ArrayList<>();
            arrayList.add(aVar.bDR);
            arrayList.add(aVar.bDS);
            arrayList.add(aVar.bDT);
            d(item.Cg(), arrayList);
            aa(view);
            aVar.bDW.setTag(item);
            aVar.bDV.setTag(item);
            aVar.bDL.setTag(item);
        }
        aVar.bDW.setOnClickListener(this);
        aVar.bDV.setOnClickListener(this);
        aVar.bDL.setOnClickListener(this);
        return view;
    }

    private void d(List<String> list, List<HeadImageView> list2) {
        if (list != null && list2 != null && list2.size() > 0) {
            int size = list.size();
            int size2 = list2.size();
            for (int i = 0; i < size2; i++) {
                if (list2.get(i) != null) {
                    list2.get(i).setVisibility(8);
                }
            }
            if (size > size2) {
                a(list2.get(0), list.get(0));
                if (list2.size() > 1) {
                    a(list2.get(1), list.get(1));
                }
                if (list2.size() > 2) {
                    a(list2.get(2), list.get(2));
                }
            } else if (size < size2) {
                if (size == 1) {
                    a(list2.get(0), list.get(0));
                } else if (size == 2) {
                    a(list2.get(0), list.get(0));
                    if (list2.size() > 1) {
                        a(list2.get(1), list.get(1));
                    }
                }
            } else {
                a(list2.get(0), list.get(0));
                a(list2.get(1), list.get(1));
                a(list2.get(2), list.get(2));
            }
        }
    }

    private void a(HeadImageView headImageView, String str) {
        if (headImageView != null) {
            headImageView.setVisibility(0);
            headImageView.c(str, 12, false);
        }
    }

    private void aa(View view) {
        this.aaI.getLayoutMode().ah(TbadkCoreApplication.m9getInst().getSkinType() == 1);
        this.aaI.getLayoutMode().t(view);
    }

    public void c(ListView listView) {
        ListAdapter adapter = listView.getAdapter();
        if (adapter != null) {
            int i = 0;
            for (int i2 = 0; i2 < adapter.getCount(); i2++) {
                View view = adapter.getView(i2, null, listView);
                view.measure(0, 0);
                i += view.getMeasuredHeight();
            }
            ViewGroup.LayoutParams layoutParams = listView.getLayoutParams();
            layoutParams.height = (listView.getDividerHeight() * (adapter.getCount() - 1)) + i;
            listView.setLayoutParams(layoutParams);
        }
    }

    /* loaded from: classes.dex */
    private class a {
        LinearLayout bDL;
        BarImageView bDM;
        TextView bDN;
        ImageView bDO;
        ImageView bDP;
        TextView bDQ;
        HeadImageView bDR;
        HeadImageView bDS;
        HeadImageView bDT;
        TextView bDU;
        LinearLayout bDV;
        LinearLayout bDW;
        TextView bDX;
        TextView bDY;

        private a() {
        }

        /* synthetic */ a(c cVar, a aVar) {
            this();
        }
    }

    private void f(String str, String str2, boolean z) {
        if (au.aG(str2)) {
            this.aaI.sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, new FrsActivityConfig(this.aaI.getPageActivity()).createNormalCfg(str2, str, z)));
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        e eVar;
        if (view != null && (view.getTag() instanceof e) && (eVar = (e) view.getTag()) != null) {
            boolean z = !x.q(eVar.Cg());
            if (view.getId() == w.h.new_thread) {
                f(FrsActivityConfig.FRS_FROM_FREQUENTLT_FORUM_NEW_THREAD, eVar.getForumName(), z);
            } else if (view.getId() == w.h.post_thread) {
                f(FrsActivityConfig.FRS_FROM_FREQUENTLY_FORUM_POST_THREAD, eVar.getForumName(), z);
            } else if (view.getId() == w.h.frequently_forum_info_item) {
                f(FrsActivityConfig.FRS_FORUM_FREQUENTLY_FORUM, eVar.getForumName(), z);
            }
        }
    }
}
