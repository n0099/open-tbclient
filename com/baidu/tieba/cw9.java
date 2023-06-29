package com.baidu.tieba;

import android.util.Log;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
/* loaded from: classes5.dex */
public class cw9 extends Thread {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public boolean a;
    public final String b;
    public Process c;
    public BufferedReader d;
    public FileOutputStream e;
    public a f;

    /* loaded from: classes5.dex */
    public interface a {
        void a();
    }

    public cw9(String str, String str2, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str, str2, Boolean.valueOf(z)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = true;
        this.d = null;
        this.e = null;
        try {
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd-HH-mm-ss", Locale.ENGLISH);
            this.e = new FileOutputStream(new File(str, str2 + "-" + simpleDateFormat.format(new Date()) + ".txt"), true);
        } catch (FileNotFoundException e) {
            BdLog.e(Log.getStackTraceString(e));
        }
        if (z) {
            this.b = "logcat -v threadtime *:v -d";
        } else {
            this.b = "logcat -v threadtime *:v";
        }
    }

    public final void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            Process process = this.c;
            if (process != null) {
                process.destroy();
                this.c = null;
            }
            BufferedReader bufferedReader = this.d;
            if (bufferedReader != null) {
                try {
                    bufferedReader.close();
                    this.d = null;
                } catch (IOException e) {
                    BdLog.e(Log.getStackTraceString(e));
                }
            }
            FileOutputStream fileOutputStream = this.e;
            if (fileOutputStream != null) {
                try {
                    fileOutputStream.close();
                } catch (IOException e2) {
                    BdLog.e(Log.getStackTraceString(e2));
                }
                this.e = null;
            }
            a aVar = this.f;
            if (aVar != null) {
                aVar.a();
            }
        }
    }

    public void b(a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, aVar) == null) {
            this.f = aVar;
        }
    }

    public void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            this.a = false;
            a();
            interrupt();
        }
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public void run() {
        String readLine;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            try {
                try {
                    this.c = Runtime.getRuntime().exec(this.b);
                    this.d = new BufferedReader(new InputStreamReader(this.c.getInputStream()), 1024);
                    while (this.a && (readLine = this.d.readLine()) != null && this.a) {
                        if (readLine.length() != 0 && this.e != null) {
                            FileOutputStream fileOutputStream = this.e;
                            fileOutputStream.write((readLine + "\n").getBytes());
                        }
                    }
                    BdLog.d("collector complete.");
                } catch (IOException e) {
                    BdLog.e(Log.getStackTraceString(e));
                }
            } finally {
                a();
            }
        }
    }
}
