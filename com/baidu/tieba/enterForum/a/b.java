package com.baidu.tieba.enterForum.a;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.adp.lib.util.l;
import com.baidu.live.tbadk.core.util.StringHelper;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.SvgManager;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.view.BarImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.enterForum.data.k;
import java.util.ArrayList;
/* loaded from: classes9.dex */
public class b extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private ArrayList<com.baidu.tbadk.mvc.b.a> caB = new ArrayList<>();
    private InterfaceC0529b gzd;
    private boolean gze;
    private int mFrom;
    private TbPageContext<?> mPageContext;
    private String mTabName;

    /* renamed from: com.baidu.tieba.enterForum.a.b$b  reason: collision with other inner class name */
    /* loaded from: classes9.dex */
    public interface InterfaceC0529b {
        void a(View view, k kVar);

        void bN(View view);
    }

    public b(TbPageContext<?> tbPageContext, int i) {
        this.mPageContext = tbPageContext;
        this.mFrom = i;
    }

    public void setData(ArrayList<? extends com.baidu.tbadk.mvc.b.a> arrayList) {
        if (arrayList != null) {
            this.caB.clear();
            this.caB.addAll(arrayList);
            notifyDataSetChanged();
        }
    }

    @Override // android.support.v7.widget.RecyclerView.Adapter
    @NonNull
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View inflate = this.mPageContext.getPageActivity().getLayoutInflater().inflate(R.layout.recommend_forum_horizontal_item_view, (ViewGroup) null);
        return i == 2 ? new a(inflate) : new c(inflate);
    }

    @Override // android.support.v7.widget.RecyclerView.Adapter
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int i) {
        if (this.caB != null && this.caB.size() > 0) {
            com.baidu.tbadk.mvc.b.a aVar = this.caB.get(i);
            if ((viewHolder instanceof a) && (aVar instanceof com.baidu.tieba.enterForum.data.a)) {
                ((a) viewHolder).a((com.baidu.tieba.enterForum.data.a) aVar);
            } else if ((viewHolder instanceof c) && (aVar instanceof k)) {
                ((c) viewHolder).a((k) aVar);
                an anVar = new an("c13642");
                anVar.t("uid", TbadkApplication.getCurrentAccountId());
                anVar.t("fid", ((k) aVar).getForumId());
                if (this.mFrom == 0) {
                    anVar.af("obj_locate", 1);
                    anVar.af("obj_type", this.gze ? 3 : 1);
                } else if (this.mFrom == 1) {
                    anVar.af("obj_locate", 2);
                    anVar.cI("resource_id", this.mTabName);
                }
                TiebaStatic.log(anVar);
            }
        }
    }

    @Override // android.support.v7.widget.RecyclerView.Adapter
    public int getItemViewType(int i) {
        if (this.caB.get(i) instanceof k) {
            return 1;
        }
        if (this.caB.get(i) instanceof com.baidu.tieba.enterForum.data.a) {
            return 2;
        }
        return 0;
    }

    @Override // android.support.v7.widget.RecyclerView.Adapter
    public int getItemCount() {
        if (this.caB == null) {
            return 0;
        }
        return this.caB.size();
    }

    public void a(InterfaceC0529b interfaceC0529b) {
        this.gzd = interfaceC0529b;
    }

    /* loaded from: classes9.dex */
    class c extends RecyclerView.ViewHolder {
        private TextView aDI;
        private String attention;
        private TextView dHz;
        private BarImageView gzf;
        private ImageView gzg;
        private k gzk;
        private View mRootView;

        public c(View view) {
            super(view);
            this.mRootView = view;
            this.attention = TbadkCoreApplication.getInst().getString(R.string.attention);
            this.gzf = (BarImageView) this.mRootView.findViewById(R.id.forum_icon);
            this.gzg = (ImageView) this.mRootView.findViewById(R.id.square_icon);
            this.dHz = (TextView) this.mRootView.findViewById(R.id.forum_name);
            this.aDI = (TextView) this.mRootView.findViewById(R.id.desc);
            this.mRootView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.enterForum.a.b.c.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    if (b.this.gzd != null) {
                        b.this.gzd.a(view2, c.this.gzk);
                    }
                }
            });
        }

        public void a(k kVar) {
            if (kVar != null) {
                this.gzk = kVar;
                this.gzf.setShowOval(true);
                this.gzf.setShowOuterBorder(false);
                this.gzf.setShowInnerBorder(true);
                this.gzf.setStrokeWith(l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds1));
                this.gzf.setStrokeColorResId(R.color.cp_border_a);
                this.gzg.setVisibility(8);
                this.gzf.setVisibility(0);
                this.gzf.startLoad(kVar.getAvatar(), 10, false);
                if (aq.getChineseAndEnglishLength(kVar.getForumName()) <= 10) {
                    this.dHz.setText(kVar.getForumName());
                } else {
                    this.dHz.setText(aq.cutChineseAndEnglishWithSuffix(kVar.getForumName(), 8, StringHelper.STRING_MORE));
                }
                this.aDI.setText(this.attention + " " + aq.cl(kVar.bHW()));
                onChangeSkinType();
            }
        }

        public void onChangeSkinType() {
            am.setViewTextColor(this.dHz, (int) R.color.cp_cont_b);
            am.setViewTextColor(this.aDI, (int) R.color.cp_cont_d);
        }
    }

    /* loaded from: classes9.dex */
    class a extends RecyclerView.ViewHolder {
        private TextView aDI;
        private String attention;
        private TextView dHz;
        private BarImageView gzf;
        private ImageView gzg;
        private View mRootView;

        public a(View view) {
            super(view);
            this.mRootView = view;
            this.attention = TbadkCoreApplication.getInst().getString(R.string.attention);
            this.gzf = (BarImageView) this.mRootView.findViewById(R.id.forum_icon);
            this.gzg = (ImageView) this.mRootView.findViewById(R.id.square_icon);
            this.dHz = (TextView) this.mRootView.findViewById(R.id.forum_name);
            this.aDI = (TextView) this.mRootView.findViewById(R.id.desc);
            this.mRootView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.enterForum.a.b.a.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    if (b.this.gzd != null) {
                        b.this.gzd.bN(view2);
                    }
                }
            });
        }

        public void a(com.baidu.tieba.enterForum.data.a aVar) {
            if (aVar != null) {
                this.gzg.setVisibility(0);
                this.gzf.setVisibility(8);
                SvgManager.aOU().a(this.gzg, R.drawable.ic_icon_pure_square28, (SvgManager.SvgResourceStateType) null);
                this.dHz.setText(R.string.forum_square_title);
                this.aDI.setText(R.string.forum_square_desc_1);
                onChangeSkinType();
            }
        }

        public void onChangeSkinType() {
            am.setViewTextColor(this.dHz, (int) R.color.cp_cont_b);
            am.setViewTextColor(this.aDI, (int) R.color.cp_cont_d);
        }
    }

    public void setTabName(String str) {
        this.mTabName = str;
    }

    public void setHasLikeForum(boolean z) {
        this.gze = z;
    }
}
