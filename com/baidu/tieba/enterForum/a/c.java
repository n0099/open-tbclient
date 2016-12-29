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
import com.baidu.tbadk.core.util.ar;
import com.baidu.tbadk.core.util.av;
import com.baidu.tbadk.core.util.x;
import com.baidu.tbadk.core.view.BarImageView;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.data.e;
import com.baidu.tieba.r;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class c extends BaseAdapter implements View.OnClickListener {
    private TbPageContext Gf;
    private List<e> aUm;

    public void a(List<e> list, TbPageContext<?> tbPageContext) {
        this.aUm = list;
        this.Gf = tbPageContext;
        notifyDataSetChanged();
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.aUm == null || this.aUm.size() <= 0) {
            return 0;
        }
        return this.aUm.size();
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return 0L;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: gz */
    public e getItem(int i) {
        if (this.aUm == null || this.aUm.size() <= 0 || this.aUm.size() <= i) {
            return null;
        }
        return this.aUm.get(i);
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        a aVar;
        if (view == null || view.getTag() == null || !(view.getTag() instanceof a)) {
            view = LayoutInflater.from(this.Gf.getPageActivity()).inflate(r.h.frequently_forum_info_item, (ViewGroup) null);
            a aVar2 = new a(this, null);
            aVar2.boS = (LinearLayout) view.findViewById(r.g.frequently_forum_info_item);
            aVar2.boT = (BarImageView) view.findViewById(r.g.frequently_forum_icon);
            aVar2.boU = (TextView) view.findViewById(r.g.forum_name);
            aVar2.boV = (ImageView) view.findViewById(r.g.level_info);
            aVar2.boW = (ImageView) view.findViewById(r.g.sign_icon);
            aVar2.boX = (TextView) view.findViewById(r.g.new_thread_count);
            aVar2.bpb = (TextView) view.findViewById(r.g.post_thread_count);
            aVar2.boY = (HeadImageView) view.findViewById(r.g.post_thread_person_one);
            aVar2.boZ = (HeadImageView) view.findViewById(r.g.post_thread_person_two);
            aVar2.bpa = (HeadImageView) view.findViewById(r.g.post_thread_person_three);
            aVar2.bpc = (LinearLayout) view.findViewById(r.g.new_thread);
            aVar2.bpd = (LinearLayout) view.findViewById(r.g.post_thread);
            aVar2.bpe = (TextView) view.findViewById(r.g.new_thread_describe);
            aVar2.bpf = (TextView) view.findViewById(r.g.post_thread_describe);
            view.setTag(aVar2);
            aVar = aVar2;
        } else {
            aVar = (a) view.getTag();
        }
        e item = getItem(i);
        if (item != null) {
            aVar.boT.c(item.BP(), 10, false);
            aVar.boU.setText(TbadkCoreApplication.m9getInst().getString(r.j.chosen_pb_original_bar, new Object[]{UtilHelper.getFixedText(item.getForumName(), 6, true)}));
            ar.k(aVar.boV, BitmapHelper.getGradeResourceIdNew(item.BR()));
            if (StringUtils.isNull(item.BQ()) || com.baidu.adp.lib.h.b.g(item.BQ(), 0) == 0) {
                aVar.boX.setVisibility(8);
                aVar.bpe.setText(this.Gf.getResources().getString(r.j.zero_new_thread_describe));
            } else {
                aVar.boX.setVisibility(0);
                aVar.bpe.setText(this.Gf.getResources().getString(r.j.new_thread_describe));
                aVar.boX.setText(av.cV(com.baidu.adp.lib.h.b.g(item.BQ(), 0)));
            }
            if (item.isSign()) {
                aVar.boW.setVisibility(0);
            } else {
                aVar.boW.setVisibility(8);
            }
            if (item.BS() != null) {
                if (item.BS().size() > 3) {
                    aVar.bpb.setVisibility(0);
                    aVar.bpb.setText("...");
                    aVar.bpf.setText(this.Gf.getResources().getString(r.j.post_thread_describe));
                } else if (item.BS().size() <= 0) {
                    aVar.bpb.setVisibility(8);
                    aVar.bpf.setText(this.Gf.getResources().getString(r.j.attention_users_thread));
                } else {
                    aVar.bpf.setText(this.Gf.getResources().getString(r.j.post_thread_describe));
                    aVar.bpb.setVisibility(8);
                }
                aVar.boY.setDefaultResource(17170445);
                aVar.boY.setDefaultErrorResource(r.f.icon_default_avatar100);
                aVar.boY.setDefaultBgResource(r.d.cp_bg_line_e);
                aVar.boY.setRadius(k.e(this.Gf.getPageActivity(), r.e.ds70));
                aVar.boZ.setDefaultResource(17170445);
                aVar.boZ.setDefaultErrorResource(r.f.icon_default_avatar100);
                aVar.boZ.setDefaultBgResource(r.d.cp_bg_line_e);
                aVar.boZ.setRadius(k.e(this.Gf.getPageActivity(), r.e.ds70));
                aVar.bpa.setDefaultResource(17170445);
                aVar.bpa.setDefaultErrorResource(r.f.icon_default_avatar100);
                aVar.bpa.setDefaultBgResource(r.d.cp_bg_line_e);
                aVar.bpa.setRadius(k.e(this.Gf.getPageActivity(), r.e.ds70));
            }
            List<HeadImageView> arrayList = new ArrayList<>();
            arrayList.add(aVar.boY);
            arrayList.add(aVar.boZ);
            arrayList.add(aVar.bpa);
            e(item.BS(), arrayList);
            X(view);
            aVar.bpd.setTag(item);
            aVar.bpc.setTag(item);
            aVar.boS.setTag(item);
        }
        aVar.bpd.setOnClickListener(this);
        aVar.bpc.setOnClickListener(this);
        aVar.boS.setOnClickListener(this);
        return view;
    }

    private void e(List<String> list, List<HeadImageView> list2) {
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

    private void X(View view) {
        this.Gf.getLayoutMode().ai(TbadkCoreApplication.m9getInst().getSkinType() == 1);
        this.Gf.getLayoutMode().x(view);
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
        LinearLayout boS;
        BarImageView boT;
        TextView boU;
        ImageView boV;
        ImageView boW;
        TextView boX;
        HeadImageView boY;
        HeadImageView boZ;
        HeadImageView bpa;
        TextView bpb;
        LinearLayout bpc;
        LinearLayout bpd;
        TextView bpe;
        TextView bpf;

        private a() {
        }

        /* synthetic */ a(c cVar, a aVar) {
            this();
        }
    }

    private void e(String str, String str2, boolean z) {
        if (av.aN(str2)) {
            this.Gf.sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, new FrsActivityConfig(this.Gf.getPageActivity()).createNormalCfg(str2, str, z)));
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        e eVar;
        if (view != null && (view.getTag() instanceof e) && (eVar = (e) view.getTag()) != null) {
            boolean z = !x.t(eVar.BS());
            if (view.getId() == r.g.new_thread) {
                e(FrsActivityConfig.FRS_FROM_FREQUENTLT_FORUM_NEW_THREAD, eVar.getForumName(), z);
            } else if (view.getId() == r.g.post_thread) {
                e(FrsActivityConfig.FRS_FROM_FREQUENTLY_FORUM_POST_THREAD, eVar.getForumName(), z);
            } else if (view.getId() == r.g.frequently_forum_info_item) {
                e(FrsActivityConfig.FRS_FORUM_FREQUENTLY_FORUM, eVar.getForumName(), z);
            }
        }
    }
}
