package com.baidu.tieba.im.chat.officialBar;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.baidu.adp.lib.util.l;
import com.baidu.live.tbadk.core.util.StringHelper;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.at;
import com.baidu.tbadk.core.view.BarImageView;
import com.baidu.tieba.R;
import java.util.ArrayList;
/* loaded from: classes26.dex */
public class d extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private ArrayList<com.baidu.tbadk.mvc.b.a> aiK = new ArrayList<>();
    private c jSb;
    private TbPageContext<?> mPageContext;

    /* loaded from: classes26.dex */
    public interface c {
        void a(View view, Object obj, int i, long j);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(TbPageContext<?> tbPageContext, c cVar) {
        this.mPageContext = tbPageContext;
        this.jSb = cVar;
    }

    public void setData(ArrayList<? extends com.baidu.tbadk.mvc.b.a> arrayList) {
        if (arrayList != null) {
            this.aiK.clear();
            this.aiK.addAll(arrayList);
            notifyDataSetChanged();
        }
    }

    @Override // android.support.v7.widget.RecyclerView.Adapter
    @NonNull
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        return new b(this.mPageContext.getPageActivity().getLayoutInflater().inflate(R.layout.official_bar_feed_header_item, (ViewGroup) null));
    }

    @Override // android.support.v7.widget.RecyclerView.Adapter
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int i) {
        if (this.aiK != null && this.aiK.size() > 0) {
            com.baidu.tbadk.mvc.b.a aVar = this.aiK.get(i);
            if ((viewHolder instanceof b) && (aVar instanceof a)) {
                ((b) viewHolder).b(aVar);
            }
        }
    }

    @Override // android.support.v7.widget.RecyclerView.Adapter
    public int getItemViewType(int i) {
        return i;
    }

    @Override // android.support.v7.widget.RecyclerView.Adapter
    public int getItemCount() {
        if (this.aiK == null) {
            return 0;
        }
        return this.aiK.size();
    }

    /* loaded from: classes26.dex */
    class b extends RecyclerView.ViewHolder implements View.OnClickListener {
        private BarImageView jSd;
        private View jSe;
        private a jSf;
        private TextView jgl;

        b(View view) {
            super(view);
            this.jSd = (BarImageView) view.findViewById(R.id.official_bar_image);
            this.jgl = (TextView) view.findViewById(R.id.official_bar_name);
            this.jSe = view.findViewById(R.id.official_bar_feed_red_dot);
            this.jSd.setShowOval(true);
            this.jSd.setPlaceHolder(2);
            this.jSd.setShowOuterBorder(false);
            this.jSd.setShowInnerBorder(true);
            this.jSd.setStrokeWith(l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds1));
        }

        void b(com.baidu.tbadk.mvc.b.a aVar) {
            this.jSf = (a) aVar;
            ap.setViewTextColor(this.jgl, R.color.cp_cont_b);
            ap.setBackgroundResource(this.jSe, R.drawable.icon_official_bar_red_dot);
            this.jSd.setStrokeColorResId(R.color.cp_border_a);
            this.jSd.startLoad(this.jSf.cMC(), 10, false);
            if (at.getChineseAndEnglishLength(this.jSf.cGz()) <= 10) {
                this.jgl.setText(this.jSf.cGz());
            } else {
                this.jgl.setText(at.cutChineseAndEnglishWithSuffix(this.jSf.cGz(), 8, StringHelper.STRING_MORE));
            }
            this.jSd.setOnClickListener(this);
            if (this.jSf.getUnReadCount() > 0 && (this.jSf.cMD() <= 0 || System.currentTimeMillis() - this.jSf.cMD() < 864000000)) {
                this.jSe.setVisibility(0);
            } else {
                this.jSe.setVisibility(8);
            }
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            this.jSe.setVisibility(8);
            if (d.this.jSb != null) {
                d.this.jSb.a(view, this.jSf, getAdapterPosition(), getItemId());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes26.dex */
    public static class a implements com.baidu.tbadk.mvc.b.a {
        private long cLK;
        private long groupId;
        private String jSc;
        private String jrg;
        private int unReadCount;
        private int userType;

        String cMC() {
            return this.jSc;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public String cGz() {
            return this.jrg;
        }

        int getUnReadCount() {
            return this.unReadCount;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public void LN(String str) {
            this.jSc = str;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public void LO(String str) {
            this.jrg = str;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public void setUnReadCount(int i) {
            this.unReadCount = i;
        }

        public void setGroupId(long j) {
            this.groupId = j;
        }

        public void setUserType(int i) {
            this.userType = i;
        }

        public long getGroupId() {
            return this.groupId;
        }

        public long cMD() {
            return this.cLK;
        }

        public void fI(long j) {
            this.cLK = j;
        }
    }
}
