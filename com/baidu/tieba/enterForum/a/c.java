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
import com.baidu.tbadk.core.util.av;
import com.baidu.tbadk.core.util.ba;
import com.baidu.tbadk.core.util.y;
import com.baidu.tbadk.core.view.BarImageView;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.data.e;
import com.baidu.tieba.u;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class c extends BaseAdapter implements View.OnClickListener {
    private TbPageContext Dp;
    private List<e> aLB;

    public void a(List<e> list, TbPageContext<?> tbPageContext) {
        this.aLB = list;
        this.Dp = tbPageContext;
        notifyDataSetChanged();
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.aLB == null || this.aLB.size() <= 0) {
            return 0;
        }
        return this.aLB.size();
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return 0L;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: gI */
    public e getItem(int i) {
        if (this.aLB == null || this.aLB.size() <= 0 || this.aLB.size() <= i) {
            return null;
        }
        return this.aLB.get(i);
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        a aVar;
        if (view == null || view.getTag() == null || !(view.getTag() instanceof a)) {
            view = LayoutInflater.from(this.Dp.getPageActivity()).inflate(u.h.frequently_forum_info_item, (ViewGroup) null);
            a aVar2 = new a(this, null);
            aVar2.bsi = (LinearLayout) view.findViewById(u.g.frequently_forum_info_item);
            aVar2.bsj = (BarImageView) view.findViewById(u.g.frequently_forum_icon);
            aVar2.bsk = (TextView) view.findViewById(u.g.forum_name);
            aVar2.bsl = (ImageView) view.findViewById(u.g.level_info);
            aVar2.bsm = (ImageView) view.findViewById(u.g.sign_icon);
            aVar2.bsn = (TextView) view.findViewById(u.g.new_thread_count);
            aVar2.bsr = (TextView) view.findViewById(u.g.post_thread_count);
            aVar2.bso = (HeadImageView) view.findViewById(u.g.post_thread_person_one);
            aVar2.bsp = (HeadImageView) view.findViewById(u.g.post_thread_person_two);
            aVar2.bsq = (HeadImageView) view.findViewById(u.g.post_thread_person_three);
            aVar2.bss = (LinearLayout) view.findViewById(u.g.new_thread);
            aVar2.bst = (LinearLayout) view.findViewById(u.g.post_thread);
            aVar2.bsu = (TextView) view.findViewById(u.g.new_thread_describe);
            aVar2.bsv = (TextView) view.findViewById(u.g.post_thread_describe);
            view.setTag(aVar2);
            aVar = aVar2;
        } else {
            aVar = (a) view.getTag();
        }
        e item = getItem(i);
        if (item != null) {
            aVar.bsj.c(item.AE(), 10, false);
            aVar.bsk.setText(TbadkCoreApplication.m9getInst().getString(u.j.chosen_pb_original_bar, new Object[]{UtilHelper.getFixedText(item.getForumName(), 6, true)}));
            av.k(aVar.bsl, BitmapHelper.getGradeResourceIdNew(item.AG()));
            if (StringUtils.isNull(item.AF()) || com.baidu.adp.lib.h.b.g(item.AF(), 0) == 0) {
                aVar.bsn.setVisibility(8);
                aVar.bsu.setText(this.Dp.getResources().getString(u.j.zero_new_thread_describe));
            } else {
                aVar.bsn.setVisibility(0);
                aVar.bsu.setText(this.Dp.getResources().getString(u.j.new_thread_describe));
                aVar.bsn.setText(ba.cE(com.baidu.adp.lib.h.b.g(item.AF(), 0)));
            }
            if (item.isSign()) {
                aVar.bsm.setVisibility(0);
            } else {
                aVar.bsm.setVisibility(8);
            }
            if (item.AH() != null) {
                if (item.AH().size() > 3) {
                    aVar.bsr.setVisibility(0);
                    aVar.bsr.setText("...");
                    aVar.bsv.setText(this.Dp.getResources().getString(u.j.post_thread_describe));
                } else if (item.AH().size() <= 0) {
                    aVar.bsr.setVisibility(8);
                    aVar.bsv.setText(this.Dp.getResources().getString(u.j.zero_post_thread_describe));
                } else {
                    aVar.bsv.setText(this.Dp.getResources().getString(u.j.post_thread_describe));
                    aVar.bsr.setVisibility(8);
                }
                aVar.bso.setDefaultResource(17170445);
                aVar.bso.setDefaultErrorResource(u.f.icon_default_avatar100);
                aVar.bso.setDefaultBgResource(u.d.cp_bg_line_e);
                aVar.bso.setRadius(k.c(this.Dp.getPageActivity(), u.e.ds70));
                aVar.bsp.setDefaultResource(17170445);
                aVar.bsp.setDefaultErrorResource(u.f.icon_default_avatar100);
                aVar.bsp.setDefaultBgResource(u.d.cp_bg_line_e);
                aVar.bsp.setRadius(k.c(this.Dp.getPageActivity(), u.e.ds70));
                aVar.bsq.setDefaultResource(17170445);
                aVar.bsq.setDefaultErrorResource(u.f.icon_default_avatar100);
                aVar.bsq.setDefaultBgResource(u.d.cp_bg_line_e);
                aVar.bsq.setRadius(k.c(this.Dp.getPageActivity(), u.e.ds70));
            }
            List<HeadImageView> arrayList = new ArrayList<>();
            arrayList.add(aVar.bso);
            arrayList.add(aVar.bsp);
            arrayList.add(aVar.bsq);
            d(item.AH(), arrayList);
            W(view);
            aVar.bst.setTag(item);
            aVar.bss.setTag(item);
            aVar.bsi.setTag(item);
        }
        aVar.bst.setOnClickListener(this);
        aVar.bss.setOnClickListener(this);
        aVar.bsi.setOnClickListener(this);
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

    private void W(View view) {
        this.Dp.getLayoutMode().ad(TbadkCoreApplication.m9getInst().getSkinType() == 1);
        this.Dp.getLayoutMode().w(view);
    }

    public void a(ListView listView) {
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
        LinearLayout bsi;
        BarImageView bsj;
        TextView bsk;
        ImageView bsl;
        ImageView bsm;
        TextView bsn;
        HeadImageView bso;
        HeadImageView bsp;
        HeadImageView bsq;
        TextView bsr;
        LinearLayout bss;
        LinearLayout bst;
        TextView bsu;
        TextView bsv;

        private a() {
        }

        /* synthetic */ a(c cVar, a aVar) {
            this();
        }
    }

    private void f(String str, String str2, boolean z) {
        if (ba.aL(str2)) {
            this.Dp.sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, new FrsActivityConfig(this.Dp.getPageActivity()).createNormalCfg(str2, str, z)));
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        e eVar;
        if (view != null && (view.getTag() instanceof e) && (eVar = (e) view.getTag()) != null) {
            boolean z = !y.t(eVar.AH());
            if (view.getId() == u.g.new_thread) {
                f(FrsActivityConfig.FRS_FROM_FREQUENTLT_FORUM_NEW_THREAD, eVar.getForumName(), z);
            } else if (view.getId() == u.g.post_thread) {
                f(FrsActivityConfig.FRS_FROM_FREQUENTLY_FORUM_POST_THREAD, eVar.getForumName(), z);
            } else if (view.getId() == u.g.frequently_forum_info_item) {
                f(FrsActivityConfig.FRS_FORUM_FREQUENTLY_FORUM, eVar.getForumName(), z);
            }
        }
    }
}
