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
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.at;
import com.baidu.tbadk.core.util.w;
import com.baidu.tbadk.core.view.BarImageView;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.data.e;
import com.baidu.tieba.r;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class c extends BaseAdapter implements View.OnClickListener {
    private TbPageContext Fp;
    private List<e> aPE;

    public void a(List<e> list, TbPageContext<?> tbPageContext) {
        this.aPE = list;
        this.Fp = tbPageContext;
        notifyDataSetChanged();
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.aPE == null || this.aPE.size() <= 0) {
            return 0;
        }
        return this.aPE.size();
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return 0L;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: hl */
    public e getItem(int i) {
        if (this.aPE == null || this.aPE.size() <= 0 || this.aPE.size() <= i) {
            return null;
        }
        return this.aPE.get(i);
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        a aVar;
        if (view == null || view.getTag() == null || !(view.getTag() instanceof a)) {
            view = LayoutInflater.from(this.Fp.getPageActivity()).inflate(r.j.frequently_forum_info_item, (ViewGroup) null);
            a aVar2 = new a(this, null);
            aVar2.bwF = (LinearLayout) view.findViewById(r.h.frequently_forum_info_item);
            aVar2.bwG = (BarImageView) view.findViewById(r.h.frequently_forum_icon);
            aVar2.bwH = (TextView) view.findViewById(r.h.forum_name);
            aVar2.bwI = (ImageView) view.findViewById(r.h.level_info);
            aVar2.bwJ = (ImageView) view.findViewById(r.h.sign_icon);
            aVar2.bwK = (TextView) view.findViewById(r.h.new_thread_count);
            aVar2.bwO = (TextView) view.findViewById(r.h.post_thread_count);
            aVar2.bwL = (HeadImageView) view.findViewById(r.h.post_thread_person_one);
            aVar2.bwM = (HeadImageView) view.findViewById(r.h.post_thread_person_two);
            aVar2.bwN = (HeadImageView) view.findViewById(r.h.post_thread_person_three);
            aVar2.bwP = (LinearLayout) view.findViewById(r.h.new_thread);
            aVar2.bwQ = (LinearLayout) view.findViewById(r.h.post_thread);
            aVar2.bwR = (TextView) view.findViewById(r.h.new_thread_describe);
            aVar2.bwS = (TextView) view.findViewById(r.h.post_thread_describe);
            view.setTag(aVar2);
            aVar = aVar2;
        } else {
            aVar = (a) view.getTag();
        }
        e item = getItem(i);
        if (item != null) {
            aVar.bwG.c(item.BK(), 10, false);
            aVar.bwH.setText(TbadkCoreApplication.m9getInst().getString(r.l.chosen_pb_original_bar, new Object[]{UtilHelper.getFixedText(item.getForumName(), 6, true)}));
            ap.j(aVar.bwI, BitmapHelper.getGradeResourceIdNew(item.BM()));
            if (StringUtils.isNull(item.BL()) || com.baidu.adp.lib.g.b.g(item.BL(), 0) == 0) {
                aVar.bwK.setVisibility(8);
                aVar.bwR.setText(this.Fp.getResources().getString(r.l.zero_new_thread_describe));
            } else {
                aVar.bwK.setVisibility(0);
                aVar.bwR.setText(this.Fp.getResources().getString(r.l.new_thread_describe));
                aVar.bwK.setText(at.cU(com.baidu.adp.lib.g.b.g(item.BL(), 0)));
            }
            if (item.isSign()) {
                aVar.bwJ.setVisibility(0);
            } else {
                aVar.bwJ.setVisibility(8);
            }
            if (item.BN() != null) {
                if (item.BN().size() > 3) {
                    aVar.bwO.setVisibility(0);
                    aVar.bwO.setText("...");
                    aVar.bwS.setText(this.Fp.getResources().getString(r.l.post_thread_describe));
                } else if (item.BN().size() <= 0) {
                    aVar.bwO.setVisibility(8);
                    aVar.bwS.setText(this.Fp.getResources().getString(r.l.attention_users_thread));
                } else {
                    aVar.bwS.setText(this.Fp.getResources().getString(r.l.post_thread_describe));
                    aVar.bwO.setVisibility(8);
                }
                aVar.bwL.setDefaultResource(17170445);
                aVar.bwL.setDefaultErrorResource(r.g.icon_default_avatar100);
                aVar.bwL.setDefaultBgResource(r.e.cp_bg_line_e);
                aVar.bwL.setRadius(k.e(this.Fp.getPageActivity(), r.f.ds70));
                aVar.bwM.setDefaultResource(17170445);
                aVar.bwM.setDefaultErrorResource(r.g.icon_default_avatar100);
                aVar.bwM.setDefaultBgResource(r.e.cp_bg_line_e);
                aVar.bwM.setRadius(k.e(this.Fp.getPageActivity(), r.f.ds70));
                aVar.bwN.setDefaultResource(17170445);
                aVar.bwN.setDefaultErrorResource(r.g.icon_default_avatar100);
                aVar.bwN.setDefaultBgResource(r.e.cp_bg_line_e);
                aVar.bwN.setRadius(k.e(this.Fp.getPageActivity(), r.f.ds70));
            }
            List<HeadImageView> arrayList = new ArrayList<>();
            arrayList.add(aVar.bwL);
            arrayList.add(aVar.bwM);
            arrayList.add(aVar.bwN);
            c(item.BN(), arrayList);
            ac(view);
            aVar.bwQ.setTag(item);
            aVar.bwP.setTag(item);
            aVar.bwF.setTag(item);
        }
        aVar.bwQ.setOnClickListener(this);
        aVar.bwP.setOnClickListener(this);
        aVar.bwF.setOnClickListener(this);
        return view;
    }

    private void c(List<String> list, List<HeadImageView> list2) {
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

    private void ac(View view) {
        this.Fp.getLayoutMode().ai(TbadkCoreApplication.m9getInst().getSkinType() == 1);
        this.Fp.getLayoutMode().v(view);
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
        LinearLayout bwF;
        BarImageView bwG;
        TextView bwH;
        ImageView bwI;
        ImageView bwJ;
        TextView bwK;
        HeadImageView bwL;
        HeadImageView bwM;
        HeadImageView bwN;
        TextView bwO;
        LinearLayout bwP;
        LinearLayout bwQ;
        TextView bwR;
        TextView bwS;

        private a() {
        }

        /* synthetic */ a(c cVar, a aVar) {
            this();
        }
    }

    private void f(String str, String str2, boolean z) {
        if (at.aM(str2)) {
            this.Fp.sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, new FrsActivityConfig(this.Fp.getPageActivity()).createNormalCfg(str2, str, z)));
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        e eVar;
        if (view != null && (view.getTag() instanceof e) && (eVar = (e) view.getTag()) != null) {
            boolean z = !w.s(eVar.BN());
            if (view.getId() == r.h.new_thread) {
                f(FrsActivityConfig.FRS_FROM_FREQUENTLT_FORUM_NEW_THREAD, eVar.getForumName(), z);
            } else if (view.getId() == r.h.post_thread) {
                f(FrsActivityConfig.FRS_FROM_FREQUENTLY_FORUM_POST_THREAD, eVar.getForumName(), z);
            } else if (view.getId() == r.h.frequently_forum_info_item) {
                f(FrsActivityConfig.FRS_FORUM_FREQUENTLY_FORUM, eVar.getForumName(), z);
            }
        }
    }
}
