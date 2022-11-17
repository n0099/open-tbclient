package com.baidu.tieba;

import android.app.PendingIntent;
import android.content.Intent;
import android.widget.RemoteViews;
import com.baidu.adp.BdUniqueId;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.download.DownloadData;
import com.baidu.tbadk.download.DownloadReceiver;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes3.dex */
public class ah8 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final RemoteViews a;

    /* loaded from: classes3.dex */
    public class a extends sg<in> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ah8 a;

        public a(ah8 ah8Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ah8Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = ah8Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.sg
        public void onLoaded(in inVar, String str, int i) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeLLI(1048576, this, inVar, str, i) == null) && this.a.a != null && inVar != null && inVar.p() != null) {
                this.a.a.setImageViewBitmap(R.id.obfuscated_res_0x7f0902ab, inVar.p());
            }
        }
    }

    public ah8(DownloadData downloadData, int i) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {downloadData, Integer.valueOf(i)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = new RemoteViews(TbadkCoreApplication.getInst().getPackageName(), (int) R.layout.obfuscated_res_0x7f0d023d);
        c(i);
        this.a.setTextViewText(R.id.obfuscated_res_0x7f09085b, TbadkCoreApplication.getInst().getResources().getString(R.string.obfuscated_res_0x7f0f0d28));
        this.a.setImageViewResource(R.id.obfuscated_res_0x7f090849, R.drawable.obfuscated_res_0x7f080eac);
        this.a.setImageViewResource(R.id.obfuscated_res_0x7f09084c, R.drawable.obfuscated_res_0x7f080eaa);
        this.a.setTextViewText(R.id.obfuscated_res_0x7f090847, downloadData.getUser_name());
        tg.h().m(downloadData.getApp_icon(), 17, new a(this), BdUniqueId.gen());
        Intent intent = new Intent(TbadkCoreApplication.getInst().getContext(), DownloadReceiver.class);
        intent.setPackage(TbadkCoreApplication.getInst().getPackageName());
        intent.setAction(DownloadReceiver.ACTION_PAUSE_DOWNLOAD);
        intent.putExtra(DownloadReceiver.DOWNLOAD_DATA, downloadData);
        this.a.setOnClickPendingIntent(R.id.obfuscated_res_0x7f090849, PendingIntent.getBroadcast(TbadkCoreApplication.getInst(), downloadData.getNotifyId(), intent, 134217728));
        Intent intent2 = new Intent(TbadkCoreApplication.getInst().getContext(), DownloadReceiver.class);
        intent2.setAction(DownloadReceiver.ACTION_CANCEL_DOWNLOAD);
        intent2.putExtra(DownloadReceiver.DOWNLOAD_DATA, downloadData);
        intent2.setPackage(TbadkCoreApplication.getInst().getPackageName());
        this.a.setOnClickPendingIntent(R.id.obfuscated_res_0x7f09084c, PendingIntent.getBroadcast(TbadkCoreApplication.getInst(), downloadData.getNotifyId(), intent2, 134217728));
    }

    public RemoteViews b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return this.a;
        }
        return (RemoteViews) invokeV.objValue;
    }

    public void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            this.a.setTextViewText(R.id.obfuscated_res_0x7f09085b, TbadkCoreApplication.getInst().getResources().getString(R.string.obfuscated_res_0x7f0f052e));
            this.a.setImageViewResource(R.id.obfuscated_res_0x7f090849, R.drawable.obfuscated_res_0x7f080ead);
        }
    }

    public void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            this.a.setTextViewText(R.id.obfuscated_res_0x7f09085b, TbadkCoreApplication.getInst().getResources().getString(R.string.obfuscated_res_0x7f0f0d28));
            this.a.setImageViewResource(R.id.obfuscated_res_0x7f090849, R.drawable.obfuscated_res_0x7f080eac);
        }
    }

    public void c(int i) {
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i) == null) {
            if (i > 0) {
                str = i + "%";
            } else {
                str = "0%";
            }
            this.a.setProgressBar(R.id.obfuscated_res_0x7f090859, 100, i, false);
            this.a.setTextViewText(R.id.obfuscated_res_0x7f09085a, str);
        }
    }
}
