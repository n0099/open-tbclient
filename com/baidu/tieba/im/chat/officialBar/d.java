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
/* loaded from: classes20.dex */
public class d extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private ArrayList<com.baidu.tbadk.mvc.b.a> ahU = new ArrayList<>();
    private c jhT;
    private TbPageContext<?> mPageContext;

    /* loaded from: classes20.dex */
    public interface c {
        void a(View view, Object obj, int i, long j);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(TbPageContext<?> tbPageContext, c cVar) {
        this.mPageContext = tbPageContext;
        this.jhT = cVar;
    }

    public void setData(ArrayList<? extends com.baidu.tbadk.mvc.b.a> arrayList) {
        if (arrayList != null) {
            this.ahU.clear();
            this.ahU.addAll(arrayList);
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
        if (this.ahU != null && this.ahU.size() > 0) {
            com.baidu.tbadk.mvc.b.a aVar = this.ahU.get(i);
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
        if (this.ahU == null) {
            return 0;
        }
        return this.ahU.size();
    }

    /* loaded from: classes20.dex */
    class b extends RecyclerView.ViewHolder implements View.OnClickListener {
        private TextView ixx;
        private BarImageView jhW;
        private View jhX;
        private a jhY;

        b(View view) {
            super(view);
            this.jhW = (BarImageView) view.findViewById(R.id.official_bar_image);
            this.ixx = (TextView) view.findViewById(R.id.official_bar_name);
            this.jhX = view.findViewById(R.id.official_bar_feed_red_dot);
            this.jhW.setShowOval(true);
            this.jhW.setPlaceHolder(2);
            this.jhW.setShowOuterBorder(false);
            this.jhW.setShowInnerBorder(true);
            this.jhW.setStrokeWith(l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds1));
        }

        void b(com.baidu.tbadk.mvc.b.a aVar) {
            this.jhY = (a) aVar;
            ap.setViewTextColor(this.ixx, R.color.cp_cont_b);
            ap.setBackgroundResource(this.jhX, R.drawable.icon_official_bar_red_dot);
            this.jhW.setStrokeColorResId(R.color.cp_border_a);
            this.jhW.startLoad(this.jhY.cCe(), 10, false);
            if (at.getChineseAndEnglishLength(this.jhY.cCf()) <= 10) {
                this.ixx.setText(this.jhY.cCf());
            } else {
                this.ixx.setText(at.cutChineseAndEnglishWithSuffix(this.jhY.cCf(), 8, StringHelper.STRING_MORE));
            }
            this.jhW.setOnClickListener(this);
            if (this.jhY.getUnReadCount() > 0 && (this.jhY.cCg() <= 0 || System.currentTimeMillis() - this.jhY.cCg() < 864000000)) {
                this.jhX.setVisibility(0);
            } else {
                this.jhX.setVisibility(8);
            }
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            this.jhX.setVisibility(8);
            if (d.this.jhT != null) {
                d.this.jhT.a(view, this.jhY, getAdapterPosition(), getItemId());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes20.dex */
    public static class a implements com.baidu.tbadk.mvc.b.a {
        private long coT;
        private long groupId;
        private String jhU;
        private String jhV;
        private int unReadCount;
        private int userType;

        String cCe() {
            return this.jhU;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public String cCf() {
            return this.jhV;
        }

        int getUnReadCount() {
            return this.unReadCount;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public void JX(String str) {
            this.jhU = str;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public void JY(String str) {
            this.jhV = str;
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

        public long cCg() {
            return this.coT;
        }

        public void fb(long j) {
            this.coT = j;
        }
    }
}
