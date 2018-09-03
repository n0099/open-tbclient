package com.baidu.tieba.im.creategroup;

import android.graphics.Bitmap;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tieba.f;
/* loaded from: classes3.dex */
public class i implements o {
    private int LQ;
    HeadImageView eoE;
    ImageView eoF;
    TextView eoG;
    private com.baidu.adp.widget.ImageView.a eoH = null;
    private a eoI = null;
    CreateGroupStepActivity eod;
    private int eoi;
    private int mIndex;
    View mView;

    public i(CreateGroupStepActivity createGroupStepActivity, int i, int i2, int i3) {
        this.eod = null;
        this.mView = null;
        this.eoE = null;
        this.eoF = null;
        this.eoG = null;
        this.eod = createGroupStepActivity;
        this.mView = LayoutInflater.from(createGroupStepActivity.getPageContext().getPageActivity()).inflate(f.h.create_group_step3_view, (ViewGroup) null);
        this.eoF = (ImageView) this.mView.findViewById(f.g.step3_img_bg);
        this.eoE = (HeadImageView) this.mView.findViewById(f.g.step3_img_scr);
        this.eoG = (TextView) this.mView.findViewById(f.g.create_group3);
        this.mIndex = i;
        this.LQ = i2;
        this.eoi = i3;
    }

    public void aIq() {
        if (this.eoI != null) {
            this.eoI.cancel();
        }
        this.eoH = null;
        this.eoI = new a();
        this.eoI.execute(new Object[0]);
    }

    public ImageView aIr() {
        return this.eoF;
    }

    public TextView aIs() {
        return this.eoG;
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public View getView() {
        return this.mView;
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public void aIb() {
        this.eoF.setBackgroundDrawable(null);
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public void aIc() {
        this.eod.getLayoutMode().setNightMode(TbadkApplication.getInst().getSkinType() == 1);
        this.eod.getLayoutMode().onModeChanged(this.mView);
        this.eoE.refresh();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public class a extends BdAsyncTask<Object, Integer, Bitmap> {
        private a() {
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPreExecute() {
            super.onPreExecute();
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: n */
        public Bitmap doInBackground(Object... objArr) {
            return com.baidu.tbadk.core.util.l.aa(null, TbConfig.GROUP_HEAD_FILE);
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            super.cancel(true);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onCancelled() {
            super.onCancelled();
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(Bitmap bitmap) {
            super.onPostExecute((a) bitmap);
            if (bitmap != null) {
                i.this.eoE.setVisibility(0);
                i.this.eoH = new com.baidu.adp.widget.ImageView.a(bitmap, false, (String) null);
                i.this.eoH.a(i.this.eoE);
            }
        }
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public String getTitle() {
        return String.format(this.eod.getPageContext().getString(f.j.group_create_step_photo), Integer.valueOf(this.LQ));
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public String aIe() {
        if (this.mIndex != this.eoi) {
            return this.eod.getPageContext().getString(f.j.next_step);
        }
        return this.eod.getPageContext().getString(f.j.group_create_step_done_tip);
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public boolean aIf() {
        return true;
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public int aHV() {
        return this.mIndex;
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public String getErrMsg() {
        return null;
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public boolean aIg() {
        return true;
    }
}
